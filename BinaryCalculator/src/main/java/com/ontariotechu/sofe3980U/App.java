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
        Binary bin1 = new Binary(scanner.nextLine());
        
        System.out.print("Enter the second binary number: ");
        Binary bin2 = new Binary(scanner.nextLine());

        System.out.println("First binary number is " + bin1.getValue());
        System.out.println("Second binary number is " + bin2.getValue());

        Binary sum = Binary.add(bin1, bin2);
        System.out.println("Their summation is " + sum.getValue());

        Binary orRslt = Binary.or(bin1, bin2);
        System.out.println("Their bitwise OR is " + orRslt.getValue());

        Binary andRslt = Binary.and(bin1, bin2);
        System.out.println("Their bitwise AND is " + andRslt.getValue());

        Binary multRslt = Binary.multiply(bin1, bin2);
        System.out.println("Their multiplication is " + multRslt.getValue());
        
        scanner.close();
    }
}