package com.lin.json;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {

        Test t = new Test();
        t.test();


    }

    private void test() {
        LocalDate birthDate = LocalDate.of(1980, 5, 17);
        // exercise
        int actual = calculateAge(birthDate, LocalDate.of(2000, 5, 17));

        System.out.println(actual);

    }

    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }


}
