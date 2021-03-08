package com.ikubinfo.testing.examples;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ParameterizedTestExample {

    @ParameterizedTest
    @ValueSource(strings = { "cali", "bali", "dan" })
    void endsWithI(String str) {
        assertTrue(str.endsWith("i"));
    }
}