package com.ikubinfo.testing.examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class BeforeEachExample {
	@BeforeEach
	void init(TestInfo testInfo) {
		String callingTest = testInfo.getTestMethod().get().getName();
		System.out.println(callingTest);
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