package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//TODO: create array logic here and move it away from here when it works
		// So the assignment is to check between array numbers how many numbers fit between them the least, in other words, how many times can we increment the first number by 1 between them (until the number to compare with an offset of -1)
		int[] test1 = {1, 4, 10};
		//TODO: find out if the array size is always fixed to 2 (3 values)
		//TODO: this comparison should check all values between each other so 1 should against 4 and 10, 4 should check against 1 and 10, 10 should check against 4 and 1 etc
		int numbersToFitBetween = 0;	
		for (int i = 0; i < test1.length; i++) {
			if(i + 1 == test1.length) {break;}
			
 			int nextNumberToCompare = test1[i + 1];
			int currentNumbersToFitBetween = 0;
			for(int j = 0; test1[i] + j < nextNumberToCompare - 1; j++) {
				currentNumbersToFitBetween++;
				System.out.println("numbers to fit: " + numbersToFitBetween);
			}

			//On first iteration we have to get the first value to compare later
			if(i == 0) { 
				numbersToFitBetween = currentNumbersToFitBetween; 
			} 
			else if(currentNumbersToFitBetween <= numbersToFitBetween && currentNumbersToFitBetween > 0) { 
				numbersToFitBetween = currentNumbersToFitBetween; 
			} 
		}

		System.out.println("vastaus on: " + numbersToFitBetween);

	}


}
