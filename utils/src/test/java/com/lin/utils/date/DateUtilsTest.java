package com.lin.utils.date;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateUtilsTest {

    @DisplayName("Test DateUtils.resolveCalculateDaysForMonth()")
    @Test
    void testResolveCalculateDaysForMonth(){
        //(一)當月加保者，自加保日起計收至當月底止
        assertEquals(16, DateUtils.resolveCalculateDaysForMonth(LocalDate.parse("2023-01-01"), LocalDate.parse("2023-01-15"),null));
        assertEquals(1, DateUtils.resolveCalculateDaysForMonth(LocalDate.parse("2023-01-01"), LocalDate.parse("2023-01-30"),null));
        assertEquals(1, DateUtils.resolveCalculateDaysForMonth(LocalDate.parse("2023-01-01"), LocalDate.parse("2023-01-31"),null));

        assertEquals(23, DateUtils.resolveCalculateDaysForMonth(LocalDate.parse("2023-02-01"), LocalDate.parse("2023-02-08"),null));
        assertEquals(3, DateUtils.resolveCalculateDaysForMonth(LocalDate.parse("2023-02-01"), LocalDate.parse("2023-02-28"),null));

        //(二)當月退保者，自當月1日起計收至退保當日或當月底止
        assertEquals(15, DateUtils.resolveCalculateDaysForMonth(LocalDate.parse("2023-01-01"), null,LocalDate.parse("2023-01-15")));
        assertEquals(30, DateUtils.resolveCalculateDaysForMonth(LocalDate.parse("2023-01-01"), null,LocalDate.parse("2023-01-30")));
        assertEquals(30, DateUtils.resolveCalculateDaysForMonth(LocalDate.parse("2023-01-01"), null,LocalDate.parse("2023-01-31")));

        assertEquals(8, DateUtils.resolveCalculateDaysForMonth(LocalDate.parse("2023-02-01"), null,LocalDate.parse("2023-02-08")));
        assertEquals(28, DateUtils.resolveCalculateDaysForMonth(LocalDate.parse("2023-02-01"), null,LocalDate.parse("2023-02-28")));

        //(三)同月份加、退保者，自加保當日起計收至退保當日或當月底止
        assertEquals(16, DateUtils.resolveCalculateDaysForMonth(LocalDate.parse("2023-01-01"), LocalDate.parse("2023-01-05"),LocalDate.parse("2023" +
                "-01-20")));
        assertEquals(11, DateUtils.resolveCalculateDaysForMonth(LocalDate.parse("2023-01-01"), LocalDate.parse("2023-01-20"),LocalDate.parse("2023" +
                "-01-31")));
        assertEquals(1, DateUtils.resolveCalculateDaysForMonth(LocalDate.parse("2023-01-01"), LocalDate.parse("2023-01-30"),LocalDate.parse("2023" +
                "-01-31")));

        assertEquals(16, DateUtils.resolveCalculateDaysForMonth(LocalDate.parse("2023-02-01"), LocalDate.parse("2023-02-03"),LocalDate.parse("2023" +
                "-02-18")));
        assertEquals(11, DateUtils.resolveCalculateDaysForMonth(LocalDate.parse("2023-02-01"), LocalDate.parse("2023-02-18"),LocalDate.parse("2023" +
                "-02-28")));
    }
}
