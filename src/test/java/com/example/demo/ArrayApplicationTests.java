package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArrayApplicationTests {

	@Autowired
	private ArrayApplication arrayApp;

	@Test
	//Only the second number has least numbers between and 1 < 4
	void oneLeastNumberSmaller() {
		int[] testArray = {15, 1, 4, 10};
		int answer = arrayApp.leastNumbersBetween(testArray);
		assertEquals(2, answer);
	}

	@Test
	//Only the first number has least numbers between that and 4 > 1
	void oneLeastNumberBigger() {
		int[] testArray = {4, 1, 10, 15};
		int answer = arrayApp.leastNumbersBetween(testArray);
		assertEquals(2, answer);
	}

	@Test
	//2 and 4 have 1 number between
	void sameNumbersWithLeast() {
		int[] testArray = {2, 4, 2, 4};
		int answer = arrayApp.leastNumbersBetween(testArray);
		assertEquals(1, answer);
	}

	@Test
	//Should be 0, no number fit between
	void noNumbersBetween() {
		int[] testArray = {2, 2, 2, 2};
		int answer = arrayApp.leastNumbersBetween(testArray);
		assertEquals(0, answer);
	}
}
