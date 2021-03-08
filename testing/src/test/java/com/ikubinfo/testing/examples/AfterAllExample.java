package com.ikubinfo.testing.examples;
import org.junit.jupiter.api.*;

public class AfterAllExample {

    @Test
    void firstTest() {
        System.out.println(1);
    }
    @Test
    void secondTest() {
        System.out.println(2);
    }

    @AfterAll
    static void after() {
        System.out.println("Only run once after all tests");
    }
}