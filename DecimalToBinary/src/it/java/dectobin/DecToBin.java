package it.java.dectobin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DecToBin {
   
	public static void main(String args[]) {
	int a;
     System.out.print("Insert decimal number: ");
     Scanner scan=new Scanner(System.in);
     a=scan.nextInt();
     scan.close();
     System.out.println("Decimal number: "+a);
     System.out.print("Binary value: ");
     ArrayList<Integer> binario=new ArrayList<Integer>();
     do {
         binario.add(a%2);
         a=(a/2)+1;
         a--;

         }while(a!=0);
     Collections.reverse(binario);
    System.out.print(binario);

     }
}
