package it.java.bintodec;

import java.util.Scanner;
public class BinToDec {
private int decimal;
private int singleString;
private int tmp;

	public int binToDec(String binario) {
		for(int i=0;i<binario.length();i++) {
			  String substring = binario.substring((binario.length()-1)-i,binario.length()-i);
              
      if (substring.equals("0")) singleString = 0;
      else singleString = 1;
             
      int power = (int) Math.pow(2.0,i);
      int tmp=singleString*power;
      decimal=decimal+tmp;
      
		}
		return (int) decimal;
	}
	
	public static void main(String args[]) {
		 String a;
	     System.out.print("Insert binary number: ");
	     Scanner scan=new Scanner(System.in);
	     a=scan.nextLine();
	     System.out.println("Binary number: "+a);
	     BinToDec dec=new BinToDec();
	     if(a.contains("2")||a.contains("3")||a.contains("4")||a.contains("5")||a.contains("6")||a.contains("7")||a.contains("8")||a.contains("8")) {
	    	 System.out.println("Binary number not correct!!!");
	     }else {
	    	 System.out.println("Decimal value of "
		             +a+" is: "+dec.binToDec(a));
	     }
	     }
	}
