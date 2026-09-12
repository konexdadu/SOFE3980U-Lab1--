package com.ontariotechu.sofe3980U;

import org.joda.time.LocalTime;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the first binary number: ");
        Binary binary1 = new Binary(scanner.nextLine());
        
        System.out.print("Enter the second binary number: ");
        Binary binary2 = new Binary(scanner.nextLine());

        System.out.println("First binary number is " + binary1.getValue());
        System.out.println("Second binary number is " + binary2.getValue());

        Binary sum = Binary.add(binary1, binary2);
        System.out.println("Their summation is " + sum.getValue());

        Binary orResult = Binary.or(binary1, binary2);
        System.out.println("Their bitwise OR is " + orResult.getValue());

        Binary andResult = Binary.and(binary1, binary2);
        System.out.println("Their bitwise AND is " + andResult.getValue());

        Binary multResult = Binary.multiply(binary1, binary2);
        System.out.println("Their multiplication is " + multResult.getValue());
        
        scanner.close();
    }
}