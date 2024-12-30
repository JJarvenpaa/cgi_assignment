package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//TODO: create array logic here and move it away from here when it works
		int[] test1 = {1, 4, 10};

		for (int i = 1; i < test1.length; i++) {
			if(i == test1.length) {break;}
			//System.out.println(i);
			//System.out.println(test1.length);
			Integer numbersToFitBetween = null;	
			Integer nextNumberToCompare = test1[i++];
			while(test1[i] + 1 < nextNumberToCompare) {
				System.out.println("joo");
			}
			numbersToFitBetween = test1[i] - nextNumberToCompare;
			System.out.println(numbersToFitBetween);
		}

	}


}
