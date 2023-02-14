package com.lin.utils.date;

import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DateRange {
    LocalDate start;
    LocalDate end;



    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY/MM/dd");
        return (this.start==null?"Min":formatter.format(this.start))+ " - " + (this.end==null?"Max":formatter.format(this.end));
    }
}
