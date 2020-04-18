package it.uniroma2.sgs;

import java.util.ArrayList;

public class Stats {
	
	
	 public static double media2(int[] l) {
	        double sum = 0.0;
	        for (int d : l)
	            sum += d;
	        return sum / l.length;
	    }

	    public static double sd2(int[] l) {
	        double avg = media2(l);
	        double sum = 0.0;
	        for (int d : l)
	            sum += Math.pow(d - avg, 2.0);
	        return sum / l.length;
	    }

	    public static double media3(ArrayList<Integer> l) {
	        double sum = 0.0;
	        for (Integer d : l)
	            sum += d;
	        return sum / l.size();
	    }

	    public static double sd3(ArrayList<Integer> l) {
	        double avg = media3(l);
	        double sum = 0.0;
	        for (Integer d : l)
	            sum += Math.pow(d - avg, 2.0);
	        return sum / l.size();
	    }
	    
	    
    public static double media(ArrayList<Double> l) {
        double sum = 0.0;
        for (Double d : l)
            sum += d;
        return sum / l.size();
    }

    public static double sd(ArrayList<Double> l) {
        double avg = media(l);
        double sum = 0.0;
        for (Double d : l)
            sum += Math.pow(d - avg, 2.0);
        return sum / l.size();
    }

    public static double min(ArrayList<Double> l) {
        double min = Double.MAX_VALUE;
        for (Double d : l)
            if (d < min)
                min = d;
        return min;
    }

    public static double max(ArrayList<Double> l) {
        double max = Double.MIN_VALUE;
        for (Double d : l)
            if (d > max)
                max = d;
        return max;
    }

}
