package org.xml.demo;

import lombok.*;

@Value
public class LombokDemo {

    private int var1;

    @EqualsAndHashCode.Exclude
    private final String var2;


    public static void main(String[] args) {

        LombokDemo lombok = new LombokDemo(1, "test");

    }
}
