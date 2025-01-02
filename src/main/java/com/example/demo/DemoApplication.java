package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//TODO: create array logic here and move it away from here when it works
		// So the assignment is to check between array numbers how many numbers fit between them the least, in other words, how many times can we increment the first number by 1 between them (until the number to compare with an offset of -1)
		int[] test1 = {6, 4, 4, 6};
		//TODO: find out if the array size is always fixed to 2 (3 values)
		//TODO: this comparison should check all values between each other so 1 should against 4 and 10, 4 should check against 1 and 10, 10 should check against 4 and 1 etc
		int numberCountBetween = 0;	
		for (int i = 0; i < test1.length; i++) {
			if(i + 1 == test1.length) {break;}
			
			numberCountBetween = compareNumbersToLength(i, test1, numberCountBetween);

		}

		System.out.println("vastaus on: " + numberCountBetween);

	}

	public static int compareNumbersToLength(int currentIndex, int[] array, int numberCountBetween) {
		int startNumberIndex = currentIndex;
		int currentNumberCountBetween = 0;

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
		if(array[startNumberIndex] < nextNumberToCompare) {
			//incrementing happens if starting number < nextnumber, decreasing happens if other way around
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
