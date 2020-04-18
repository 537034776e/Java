package it.uniroma2.sgs;

import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main {
	static int a1 = 27;
	static int seme = 5;
	static int m=(int) Math.pow(2,12);
    static GeneratoreMoltiplicativo g = new GeneratoreMoltiplicativo(seme, a1, m);

	public static void main(String[] args) throws IOException {
		sequenzaUniforme();
		/*System.out.println("---------------------------------------------------------");
        System.out.println();
		sequenzaPoisson();
		System.out.println("---------------------------------------------------------");
		System.out.println();
		sequenzaRn();
		System.out.println("---------------------------------------------------------");
		System.out.println();
		sequenzaGauss();
		System.out.println("---------------------------------------------------------");
		System.out.println();
		sequenzaIperexp();
		System.out.println("---------------------------------------------------------");
		System.out.println();
		sequenzaErlang();*/
		
	}
	
	
	public static void sequenzaRn() {
		ArrayList<Double> genmolt = new ArrayList<Double>();
		double tmp = g.get_next_in_01();
			
	
		while (!genmolt.contains(tmp)) {
				
			
			genmolt.add(tmp);
		    tmp = g.get_next_in_01();
		}
		
        System.out.println();

        System.out.println("Media: " + Stats.media(genmolt));
        System.out.println("Varianza: " + Stats.sd(genmolt));
        
        System.out.println();
      
        String output2 = "Elemento\tValore\tIstogramma";


		for ( int counter = 0; counter < genmolt.size(); counter++ ) {
			output2 += "\n" + counter + "\t" + genmolt.get(counter) + "\t";
			for ( int stars = 0; stars < genmolt.get(counter); stars++ )
		        output2 += "*";
			
		}
		JTextArea textArea = new JTextArea(output2);
		JScrollPane scrollPane = new JScrollPane(textArea);  
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true); 
		scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
		JOptionPane.showMessageDialog(null, scrollPane, "Istogramma Rn",  
		                                       JOptionPane.YES_NO_OPTION);
	}
	
	public static void sequenzaGauss() {
		double media=30;
		int var=25;
		Gaussiana gauss=new Gaussiana (g, media, var);
		ArrayList<Double> gaussiana = new ArrayList<Double>();
		double tmp = gauss.get_next();
		while (!gaussiana.contains(tmp)) {
				
			
			gaussiana.add(tmp);
		    tmp = gauss.get_next();
		}
		
        System.out.println();

		 System.out.println("Media: " + Stats.media(gaussiana));
	        System.out.println("Varianza: " + Stats.sd(gaussiana));
	        System.out.println();
	       
	        String output2 = "Elemento\tValore\tIstogramma";


			for ( int counter = 0; counter < gaussiana.size(); counter++ ) {
				output2 += "\n" + counter + "\t" + gaussiana.get(counter) + "\t";
				for ( int stars = 0; stars < gaussiana.get(counter); stars++ )
			        output2 += "*";
				
			}
			JTextArea textArea = new JTextArea(output2);
			JScrollPane scrollPane = new JScrollPane(textArea);  
			textArea.setLineWrap(true);  
			textArea.setWrapStyleWord(true); 
			scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
			JOptionPane.showMessageDialog(null, scrollPane, "Istogramma Gaussiana",  
			                                       JOptionPane.YES_NO_OPTION);
		}
	
	public static void sequenzaErlang() {
		double ts=5;
		int k=5;
		Erlang erl=new Erlang (g, ts, k);
		ArrayList<Double> erlang = new ArrayList<Double>();
		double tmp = erl.get_next();
		while (!erlang.contains(tmp)) {
				
			
			erlang.add(tmp);
		    tmp = erl.get_next();
		}
		
        System.out.println();

		 System.out.println("Media: " + Stats.media(erlang));
	        System.out.println("Varianza: " + Stats.sd(erlang));
	        System.out.println();
	    
	        String output2 = "Elemento\tValore\tIstogramma";


			for ( int counter = 0; counter < erlang.size(); counter++ ) {
				output2 += "\n" + counter + "\t" + erlang.get(counter) + "\t";
				for ( int stars = 0; stars < erlang.get(counter); stars++ )
			        output2 += "*";
				
			}
			JTextArea textArea = new JTextArea(output2);
			JScrollPane scrollPane = new JScrollPane(textArea);  
			textArea.setLineWrap(true);  
			textArea.setWrapStyleWord(true); 
			scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
			JOptionPane.showMessageDialog(null, scrollPane, "Istogramma Erlang",  
			                                       JOptionPane.YES_NO_OPTION);
		}
	public static void sequenzaPoisson() {
		int media=2;
		int t=20;
		

		Poisson poi=new Poisson(g, media, t);
		ArrayList<Double> poisson=new ArrayList<Double>();
        for (int i=0; i<1024; i++) {
        	int tmp=(int) poi.get_next();
        	poisson.add((double) tmp);
        }
	
		int[] poissoninteri = new int[poisson.size()];
		for (int i = 0; i < poisson.size(); i++) {
			poissoninteri[i] = poisson.get(i).intValue();
			System.out.print(i+"            ");
			System.out.println(poissoninteri[i]);

		}
		
		 System.out.println();

	        System.out.println("Media: " + Stats.media2(poissoninteri));
	        System.out.println("Varianza: " + Stats.sd2(poissoninteri));
	        System.out.println();
		
		String output2 = "Elemento\tValore\tIstogramma";


		for ( int counter = 0; counter < poissoninteri.length; counter++ ) {
			output2 += "\n" + counter + "\t" + poissoninteri[counter] + "\t";
			for ( int stars = 0; stars < poissoninteri[counter]; stars++ )
		        output2 += "*";
			
		}
		JTextArea textArea = new JTextArea(output2);
		JScrollPane scrollPane = new JScrollPane(textArea);  
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true); 
		scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
		JOptionPane.showMessageDialog(null, scrollPane, "Istogramma Poisson",  
		                                       JOptionPane.YES_NO_OPTION);
	}


	public static void sequenzaIperexp() {
double p=0.3;
double ta=27;
Iperexp e=new Iperexp(g, ta, p);
ArrayList<Double> iperesponenziale = new ArrayList<Double>();
double tmp = e.get_next();
while (!iperesponenziale.contains(tmp)) {
		
	
	iperesponenziale.add(tmp);
    tmp = e.get_next();
}

System.out.println();

System.out.println("Media: " + Stats.media(iperesponenziale));
System.out.println("Varianza: " + Stats.sd(iperesponenziale));
System.out.println();
String output2 = "Elemento\tValore\tIstogramma";


for ( int counter = 0; counter < iperesponenziale.size(); counter++ ) {
	output2 += "\n" + counter + "\t" + iperesponenziale.get(counter) + "\t";
	for ( int stars = 0; stars < iperesponenziale.get(counter); stars++ )
        output2 += "*";
	
}
JTextArea textArea = new JTextArea(output2);
JScrollPane scrollPane = new JScrollPane(textArea);  
textArea.setLineWrap(true);  
textArea.setWrapStyleWord(true); 
scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
JOptionPane.showMessageDialog(null, scrollPane, "Istogramma Iperesponenziale",  
                                       JOptionPane.YES_NO_OPTION);
}
	
	public static void sequenzaUniforme() {
        
        int min=20;
        int max=60;
        UniformeInteri u=new UniformeInteri(g, min, max);
        ArrayList<Double> uniforme=new ArrayList<Double>();
        for (int i=0; i<1024; i++) {
        	int tmp=(int) u.get_next_double();
        	uniforme.add((double) tmp);
        }
	
		int[] uniformeinteri = new int[uniforme.size()];
		for (int i = 0; i < uniforme.size(); i++) {
			uniformeinteri[i] = uniforme.get(i).intValue();
			System.out.print(i+"            ");
			System.out.println(uniformeinteri[i]);

		}

    
        System.out.println();

        System.out.println("Media: " + Stats.media2(uniformeinteri));
        System.out.println("Varianza: " + Stats.sd2(uniformeinteri));
        System.out.println();
    	String output2 = "Elemento\tValore\tIstogramma";


		for ( int counter = 0; counter < uniforme.size(); counter++ ) {
			output2 += "\n" + counter + "\t" + uniforme.get(counter) + "\t";
			for ( int stars = 0; stars < uniforme.get(counter); stars++ )
		        output2 += "*";
			
		}
		JTextArea textArea = new JTextArea(output2);
		JScrollPane scrollPane = new JScrollPane(textArea);  
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true); 
		scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
		JOptionPane.showMessageDialog(null, scrollPane, "Istogramma Uniforme",  
		                                       JOptionPane.YES_NO_OPTION);
	}
	
}
