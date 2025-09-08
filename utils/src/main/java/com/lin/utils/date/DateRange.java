package com.lin.utils.date;

import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateRange {
    LocalDate start;
    LocalDate end;

    public DateRange() {
    }

    public DateRange(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY/MM/dd");
        return (this.start==null?"Min":formatter.format(this.start))+ " - " + (this.end==null?"Max":formatter.format(this.end));
    }
}
