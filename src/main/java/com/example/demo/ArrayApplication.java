package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArrayApplication {
	
    
    public static void main(String[] args) {
		SpringApplication.run(ArrayApplication.class, args);
		//leastNumbersBetween();
	}

	public int leastNumbersBetween(int[] array) {
		// So the assignment is to check between array numbers how many numbers fit between them the least, in other words, how many times can we increment the first number by 1 between them (until the number to compare with an offset of -1)
		//TODO: this should be tested with spring boot unit testing
		//int[] test1 = {1, 3, 5, 7};
		int numberCountBetween = 0;	

		for (int i = 0; i < array.length; i++) {

			if(i + 1 == array.length) break; // i + 1 to prevent array index out of bounds
			
			numberCountBetween = compareNumbersUntilLast(i, array, numberCountBetween);
		}
		//System.out.println(numberCountBetween);
		return numberCountBetween;
	}

	public static int compareNumbersUntilLast(int currentIndex, int[] array, int numberCountBetween) {
		int startNumberIndex = currentIndex;
		int currentNumberCountBetween = 0;
		// array length -1 to prevent array index out of bounds
		while(currentIndex < array.length - 1) {

			currentNumberCountBetween = countNumbersBetween(startNumberIndex, currentIndex, array);

			//set numberCountBetween with the first proper count value
			if(numberCountBetween == 0 && currentNumberCountBetween > 0) { 
				numberCountBetween = currentNumberCountBetween; 
			} 
			
			else if(currentNumberCountBetween <= numberCountBetween && currentNumberCountBetween > 0) { 
				numberCountBetween = currentNumberCountBetween; 
			} 

			currentIndex++;
		}

		

		return numberCountBetween;
	}

	public static int countNumbersBetween(int startNumberIndex, int currentIndex, int[] array) {
		int numberCountBetween = 0;
		int nextNumberToCompare = array[currentIndex + 1];
		
		//Compares numbers next in array
		if(array[startNumberIndex] < nextNumberToCompare) { //incrementing happens if starting number < nextnumber, decreasing happens if other way around
			
			for(int i = 0; array[startNumberIndex] + i < nextNumberToCompare - 1; i++) {
				numberCountBetween++;
			}

		} else {

			for(int i = 0; array[startNumberIndex] - i > nextNumberToCompare + 1; i++) {
				numberCountBetween++;
			}

		}
		
		return numberCountBetween;
	}
}