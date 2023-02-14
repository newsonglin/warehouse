package com.lin.utils.date;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class DateUtils {


    /**
     * If the date range crosses multiple months, will split range into small ranges to ensure no range cross month
     * for example:  2022/12/15 - 2023/02/02 will be split as below 3 ranges:
     *     1.2022/12/15 - 2022/12/31
     *     2.2023/01/01 - 2023/01/31
     *     3.2023/02/01 - 2023/02/02
     *
     * @param range  the date range to be split
     * @return  a date range list , it contains small ranges not cross months
     */
    public static List<DateRange> splitRangeByMonth(DateRange range) throws Exception{
        List<DateRange> rangeList = new ArrayList<>();

        if (range == null || range.getStart() == null || range.getEnd() == null) {
            throw new UnsupportedOperationException("range can't be null and must have both start and end date");
        }

        //number of months
        long monthDiff = ChronoUnit.MONTHS.between(range.getStart().withDayOfMonth(1), range.getEnd().withDayOfMonth(1));

        LocalDate splitRangeStart = range.getStart();

        for (int i = 0; i <= monthDiff; i++) {
            //Just in case it's a subclass of DateRange
            DateRange splitRange = range.getClass().getDeclaredConstructor().newInstance();
            splitRange.setStart(splitRangeStart);

            if (ChronoUnit.MONTHS.between(splitRangeStart, range.getEnd()) == 0) {//in the same month already
                splitRange.setEnd(range.getEnd());
                rangeList.add(splitRange);
                break;
            } else {
                //last month day of start date
                splitRange.setEnd(splitRangeStart.withDayOfMonth(splitRangeStart.getMonth().length(splitRangeStart.isLeapYear())));
                rangeList.add(splitRange);

                //set next range start date, the first month day of next month
                splitRangeStart = splitRange.getEnd().plusMonths(1).withDayOfMonth(1);
            }

        }
        return rangeList;
    }


    /**
     * Check whether the date fall into date range or not
     * @param theDate the date to be checked
     * @param range the date range to be checked
     * @return a boolean type, true will be returned if data fall into date range, false otherwise.
     */
    public static boolean isWithinRange(LocalDate theDate, DateRange range) {
        if (theDate == null || range == null || (range.getStart() == null && range.getEnd() == null)) {
            return false;
        }
        if (range.getStart() == null) {
            return !theDate.isAfter(range.getEnd());
        } else if (range.getEnd() == null) {
            return !theDate.isBefore(range.getStart());
        } else {
            return !theDate.isBefore(range.getStart())  &&  !theDate.isAfter(range.getEnd());
        }
    }

    /**
     * reverse the date ranges
     * for example:
     * Example 1:
     *  Input:
     *   2022/12/15 - 2023/02/02
     *  Output:
     *   null - 2022/12/14
     *   2023/02/03 - null
     *
     * Example 2:
     *  Input:
     *   null - 2022/12/15
     *   2023/01/02 - 2023/03/04
     *  Output:
     *   2022/12/16 - 2023/01/01
     *   2023/03/05 - null
     * @param srcRanges the date ranges
     *               NOTE: assume that ranges have no overlap
     * @return
     */
    public static List<DateRange> reverseRanges(List<DateRange> srcRanges) throws Exception {
        List<DateRange> reverseRanges = new ArrayList<>();
        if (CollectionUtils.isEmpty(srcRanges)) {
            return reverseRanges;
        }

        //copy list and don't touch source date, and also source list maybe an unmodifiable list
        List<DateRange> ranges=new ArrayList<>(srcRanges);
        //sort by start date asc
        ranges.sort(Comparator.comparing(item-> item.getStart()==null?LocalDate.MIN:item.getStart()));

        DateRange current, next;
        for (int i = 0; i < ranges.size(); i++) {
            current = ranges.get(i);
            if (i == 0 && current.getStart() != null) {//only the first may have start empty
                DateRange reverse = current.getClass().getConstructor().newInstance();
                reverse.setEnd(current.getStart().plusDays(-1));
                reverseRanges.add(reverse);
            }

            if (i + 1 > ranges.size() - 1) {//no next already, this is the last one
                if (current.getEnd() != null) {
                    DateRange reverse = current.getClass().getConstructor().newInstance();
                    reverse.setStart(current.getEnd().plusDays(1));
                    reverse.setStart(current.getEnd().plusDays(1));
                    reverseRanges.add(reverse);
                }
            } else {// process next
                next = ranges.get(i + 1);
                long dayDiff=ChronoUnit.DAYS.between(current.getEnd(),next.getStart());
                //there is no period between next and current
                if(dayDiff<=1){
                    continue;
                }

                DateRange reverse = current.getClass().getConstructor().newInstance();
                reverse.setStart(current.getEnd().plusDays(1));
                reverse.setEnd(next.getStart().plusDays(-1));
                reverseRanges.add(reverse);
            }
        }
        return reverseRanges;
    }

    /**
     * Filter ranges by start filter date and end filter date.
     *
     * For example:
     *   srcRanges:
     *         Range 1. Min - 2022/12/15
     *         Range 2. 2023/02/15 - 2023/05/15
     *         Range 3. 2023/07/12 - 2023/09/11
     *         Range 4. 2023/12/15 - Max
     *
     *   startFilterDate:
     *         2023/05/10
     *
     *   endFilterDate:
     *         2023/08/11
     *
     *   if needTrim is null or false,method will return:
     *         Range 2. 2023/02/15 - 2023/05/15
     *         Range 3. 2023/07/12 - 2023/09/11
     *   if needTrim is true, method will return trimmed ranges:
     *         Range 2. 2023/05/10 - 2023/05/15
     *         Range 3. 2023/07/12 - 2023/08/11
     *
     * @param srcRanges  the ranges to be filtered
     * @param startFilterDate  start filter date
     * @param endFilterDate end filter date
     * @param needTrim  should trim the range based on filter date or not
     * @return filtered ranges list
     * @throws Exception if error occurs
     */
    public static List<DateRange> filterRanges(List<DateRange> srcRanges, LocalDate startFilterDate, LocalDate endFilterDate, Boolean needTrim) throws Exception {
        if (CollectionUtils.isEmpty(srcRanges)) {
            return srcRanges;
        }

        if (startFilterDate == null && endFilterDate == null) {
            throw new UnsupportedOperationException("Need specify at least one date for startFilterDate and endFilterDate");
        }


        List<DateRange> filteredRanges = new ArrayList<>();

        if (startFilterDate == null) {
            startFilterDate = LocalDate.MIN;
        }
        if (endFilterDate == null) {
            endFilterDate = LocalDate.MAX;
        }

        DateRange conditionRange= new DateRange(startFilterDate,endFilterDate);
        //copy list and don't touch source date, and also source list maybe an unmodifiable list
        List<DateRange> ranges = new ArrayList<>(srcRanges);
        //sort by start date asc
        ranges.sort(Comparator.comparing(item -> item.getStart() == null ? LocalDate.MIN : item.getStart()));
        for (DateRange range : ranges) {
            if (isRangeOverlap(conditionRange, range)) {
                filteredRanges.add(range);
            }
        }

        if (needTrim) {
            if (CollectionUtils.isEmpty(filteredRanges)) {
                return filteredRanges;
            }
            DateRange first = filteredRanges.get(0);
            DateRange last = filteredRanges.get(filteredRanges.size() - 1);

            if (first.getStart() == null || first.getStart().isBefore(startFilterDate)) {
                first.setStart(startFilterDate.isEqual(LocalDate.MIN) ? null : startFilterDate);
            }

            if (last.getEnd() == null || last.getEnd().isAfter(endFilterDate)) {
                last.setEnd(endFilterDate.isEqual(LocalDate.MAX) ? null : endFilterDate);
            }


        }


        return filteredRanges;

    }


    /**
     * Check whether 2 date ranges have overlap or not
     * @param rangeA the first range
     * @param rangeB the second range
     * @return a boolean type, true if there is overlap, false otherwise
     */
    public static boolean isRangeOverlap(DateRange rangeA, DateRange rangeB){
        if(rangeA==null || rangeB==null){
            return false;
        }

        LocalDate startA=rangeA.getStart()==null?LocalDate.MIN:rangeA.getStart();
        LocalDate endA=rangeA.getEnd()==null?LocalDate.MAX:rangeA.getEnd();

        LocalDate startB=rangeB.getStart()==null?LocalDate.MIN:rangeB.getStart();
        LocalDate endB=rangeB.getEnd()==null?LocalDate.MAX:rangeB.getEnd();

        return !startA.isAfter(endB)  &&  !endA.isBefore(startB);

    }


    public static List<DateRange> buildDateRanges(List<DateWrap> dates) {

        if (CollectionUtils.isEmpty(dates)) {
            return new ArrayList<>();
        }
        List<DateRange> result = new ArrayList<>();
        DateRange range;

        //remove duplicate
        List<DateWrap> distinctDates =
                dates.stream().collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparing(wrap->wrap.getTheDate().toString()+wrap.getType()))),
                        ArrayList::new));

        int size = distinctDates.size();

        if (size == 1) {
            range = new DateRange();
            if (DateType.START == dates.get(0).getType()) {//only start date
                range.setStart(dates.get(0).getTheDate());
            } else { //only end date
                range.setEnd(dates.get(0).getTheDate());
            }
            result.add(range);
            return result;
        }



        //sort the dates
        distinctDates.sort(comparing(DateWrap::getTheDate));

        for (int i = 0; i < size; i++) {
            DateWrap currentDateWrap = distinctDates.get(i);

            if (currentDateWrap.getType() == DateType.START) { //current is start date
                range = new DateRange();
                range.setStart(currentDateWrap.getTheDate());
                result.add(range);
                while (i + 1 < size) {
                    DateWrap nextDateWrap = distinctDates.get(i + 1);
                    if (DateType.END == nextDateWrap.getType()) {//follow with an end date
                        range.setEnd(nextDateWrap.getTheDate());
                        i = i + 1;//skip this end date in  outside for loop as we processed it
                        break; //jump out the while loop
                    } else if (DateType.START == nextDateWrap.getType()) { //follow with a start date
                        range.setEnd(nextDateWrap.getTheDate().plusDays(-1));
                        break;//jump out the while loop
                    } else {
                        System.out.println("Incorrect Date!!!");
                        i = i + 1;//skip this invalid date until we found correct one
                    }
                }

            } else if (currentDateWrap.getType() == DateType.END) {//current is end date
                //as we skip end date normally, this happens due to continuous end date or the very beginning is an end date
                range = new DateRange();
                range.setEnd(currentDateWrap.getTheDate());
                range.setStart((i - 1) < 0 ? null : distinctDates.get(i - 1).getTheDate().plusDays(1)); //the previous end date plus 1 day
                if(range.getStart()!=null && range.getEnd()!=null && range.getEnd().isBefore(range.getStart())){
                    //exceptional data jump
                    continue;
                }
                result.add(range);

            } else {//
                System.out.println("Incorrect Date!!!");
            }
        }

        return result;
    }


    public static List<DateWrap> buildRandomDateWraps(int size){
        List<Integer> yearList = Arrays.asList(2021,2022,2023);
        Random rand = new Random();
        List<DateWrap> result = new ArrayList<>();
        List<DateType> dateTypes=Arrays.asList(DateType.START,DateType.END);



        for(int i=0;i<size;i++) {
            int randomYear = yearList.get(rand.nextInt(yearList.size()));
            int randomMonth = rand.nextInt(12);
            int randomDay = rand.nextInt(31);

            if(randomMonth==0){
                randomMonth=1;
            }
            if(randomDay==0){
                randomDay=1;
            }

            if(randomMonth==2 && randomDay>28){
                randomDay=randomDay-3;
            }

            DateType randType=dateTypes.get(rand.nextInt(dateTypes.size()));
            result.add(new DateWrap(LocalDate.of(randomYear, randomMonth, randomDay), randType));
        }


        return result;
    }


    public static int resolveCalculateDaysForMonth(LocalDate targetMonth, LocalDate startDate, LocalDate endDate) {
        Objects.requireNonNull(targetMonth, "target month cannot be null");
        if (startDate==null && endDate==null) {
            System.out.println("start date and end date can not be null for both during calculation for month days");
            return 0;
        }

        long inMonthDiff = startDate == null ? -1 : ChronoUnit.MONTHS.between(targetMonth.withDayOfMonth(1), startDate.withDayOfMonth(1));
        long outMonthDiff = endDate == null ? -1 : ChronoUnit.MONTHS.between(targetMonth.withDayOfMonth(1), endDate.withDayOfMonth(1));

        if (inMonthDiff == 0) {
            if (outMonthDiff == 0) {// in and out are at the same month
                int outDay = endDate.getDayOfMonth();
                int inDay = startDate.getDayOfMonth();
                return outDay == 31 ? (outDay - inDay) : (outDay - inDay + 1);
            } else { //in is at the  month, out is not
                int result = 30 - startDate.getDayOfMonth() + 1;
                return Math.max(result, 1);
            }
        } else {
            if (outMonthDiff == 0) {//in is not at the month, out is
                int outDay = endDate.getDayOfMonth();
                return Math.min(outDay, 30);

            } else {// in is not at the month and out is not either
                return 30;
            }
        }
    }

    public static void main(String[] args) throws Exception{



        DateRange range1 = new DateRangeAdvance(null,LocalDate.parse("2022-12-15"));
        DateRange range2 = new DateRangeAdvance(null,LocalDate.parse("2023-05-15"));
        DateRange range3 = new DateRangeAdvance(LocalDate.parse("2023-07-12"),null);
        DateRange range4 = new DateRangeAdvance(LocalDate.parse("2023-12-15"),null);

        resolveCalculateDaysForMonth(LocalDate.parse("2023-01-01"), LocalDate.parse("2023-01-15"),null);



    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static class DateRangeAdvance extends DateRange{
        public DateRangeAdvance(LocalDate start, LocalDate end) {
            super(start, end);
        }

        private String status="advanced";
        @Override
        public String toString() {
            return super.toString()+" - "+this.status;
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
   static class DateWrap {
        private LocalDate theDate;
        private DateType type;
        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY/MM/dd");
            return type==null?"":type.name()+":"+ (this.theDate==null?"":formatter.format(this.theDate));
        }
    }

    enum DateType {
        START,
        END
    }
}
