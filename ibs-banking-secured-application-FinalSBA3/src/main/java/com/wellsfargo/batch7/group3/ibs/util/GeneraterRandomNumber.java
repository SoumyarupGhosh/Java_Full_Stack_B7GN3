package com.wellsfargo.batch7.group3.ibs.util;

import java.util.Random;

public class GeneraterRandomNumber {
	
public static String generateRandomChars(int length) {
	String candidateChars="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    StringBuilder sb = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < length; i++) {
        sb.append(candidateChars.charAt(random.nextInt(candidateChars
                .length())));
    }

    return sb.toString();
}

public static String generateRandomChars(String candidateChars, int length) {
	
    StringBuilder sb = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < length; i++) {
        sb.append(candidateChars.charAt(random.nextInt(candidateChars
                .length())));
    }

    return sb.toString();
}

	public static  Integer gen() { // 5 didgit long for  employee id 
	    Random r = new Random( System.currentTimeMillis() );
	    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}
 

}
