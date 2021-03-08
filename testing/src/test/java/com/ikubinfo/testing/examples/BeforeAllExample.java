package com.ikubinfo.testing.examples;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BeforeAllExample {

    @BeforeAll
    static void init() {
        System.out.println("Only run once before all tests");
    }

    @Test
    void firstTest() {
        System.out.println(1);
    }
    @Test
    void secondTest() {
        System.out.println(2);
    }
}