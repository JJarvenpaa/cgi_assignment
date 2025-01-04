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
	void oneLeastNumber() {
		int[] testArray = {1, 4, 10, 15};
		int answer = arrayApp.leastNumbersBetween(testArray);
		assertEquals(2, answer);
	}

	@Test
	void sameNumbersWithLeast() {
		int[] testArray = {2, 4, 2, 4};
		int answer = arrayApp.leastNumbersBetween(testArray);
		assertEquals(1, answer);
	}



}
