package com.lin.beanio;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * The class in claim project
 *
 * @author Songlin Li
 * @since 1.0
 */
public class Test {

    public static void main(String[] args) {

        BigDecimal n = new BigDecimal(1000000000.999);
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
//        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
//        formatter.setDecimalFormatSymbols(symbols);
        System.out.println(NumberFormat.getInstance(Locale.US).format(n));

//        System.out.println(String.format(String.format(Locale.US, "%,d", n.longValue())));
    }
}
