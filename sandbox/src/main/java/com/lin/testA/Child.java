/* Copyright © 2024 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media
without EIS Group prior written consent.*/
package com.lin.testA;

/**
 * Child
 *
 * @author Songlin Li
 * @since 8/22/2024
 */
public class Child  {

    public String aaaa(){
        return new Parent().test();
    }

    public static void main(String[] args) {
        System.out.println(new Child().aaaa());
    }
}
