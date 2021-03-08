package com.ikubinfo.testing.examples;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@DisplayName("DisplayName Demo")
public class DisplayNameExample {
    @Test
    @DisplayName("Custom test name")
    void testWithDisplayName() {
    }

    @Test
    @DisplayName("Print test name")
    void printDisplayName(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }
}