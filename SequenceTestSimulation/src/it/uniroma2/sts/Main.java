package it.uniroma2.sts;

import java.util.ArrayList;

public class Main {
  
	public static void testRn() {
		int a=11;
		int seme=5;
		int b=19;
		GeneratoreMoltiplicativo g=new GeneratoreMoltiplicativo (a,seme,b);
		ArrayList<Double> genmolt = new ArrayList<Double>();
		double tmp = g.get_next_in_01();
			
	
		while (!genmolt.contains(tmp)) {
				
			
			genmolt.add(tmp);
		    tmp = g.get_next_in_01();
		}
		Test t=new Test(a,seme,b);
		t.uniformita(a, seme, b);
		Test t1=new Test(a,seme,b);
		t1.seriale(a, seme, b);
	}
	
	
	public static void testXn() {
		int a = 10037;
	      int seed = 163;
	      int b = 19;
	Test t=new Test(a,seed,b);
	t.uniformita(a,seed,b);
	}
	public static void main (String args[]) {
testRn();
System.out.println();
System.out.println("---------------------------------------------");
System.out.println();
		  testXn();
	}
}
