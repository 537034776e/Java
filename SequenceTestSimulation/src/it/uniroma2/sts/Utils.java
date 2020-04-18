package it.uniroma2.sts;

import java.util.ArrayList;
import java.util.List;

public class Utils {

	public static double Z25 = -0.641;

    public static double Z75 = 0.641;

    public static double Z99 = 2.326;

    public static double Z10 = -1.282;

    public static double Z90 = 1.282;
	public static List<Double> generaRn(int a, int x0, int b) {
        double m = Math.pow(2.0, b);
        List<Double> l1 = new ArrayList<Double>();
        List<Double> l2 = new ArrayList<Double>();
        double next = x0;
        while (!l1.contains(next)) {
            l1.add(next);
            next = (a * next) % m;
        }
        for (Double d : l1)
            l2.add(d / m);
        return l2;
    }
	 public static double calcolaV(List<Double> yss, double n, double ps) {
	        double v = 1.0;
	        double nps = n * ps;
	        for (int i = 0 ; i < yss.size() ; i++) {
	            v += Math.pow(yss.get(i) - nps, 2) / nps;
	        }
	        System.out.println("nps: " + nps);
	        System.out.println("v: " + v);
	        System.out.println();
	        return v;
	    }

	    public static double calcolaVseriale(List<Double> yss, double n, double ps) {
	        double v = 0.0;
	        double nps = (n / 4096.0) / 2;
	        nps = (43000.0 / 2.0) / 4096.0;
	        double v1 = 0;
	        for (int i = 0 ; i < yss.size() ; i++) {
	            System.out.println("categoria " + i + " contiene " + yss.get(i) + " -> " + (Math.pow(yss.get(i) - nps, 2) / nps));
	            v += Math.pow(yss.get(i) - nps, 2) / nps;
	            if  ( yss.get(i) <= 0)
	                v1 += Math.pow(yss.get(i) - nps, 2) / nps;
	        }
	        System.out.println("nps: " + nps);
	        System.out.println("v: " + v);
	        System.out.println("v1: " + v1);
	        System.out.println();
	        return v;
	    }

	    public static double calcolaChiQuadro(double df, double za) {
	        double a = 1.0;
	        double b = 2.0 / (9.0 * df);
	        double c = za * Math.sqrt(2.0 / (9.0 * df));
	        double abc = a - b + c;
	        double cube = Math.pow(abc, 3);
	        return (df * cube);
	    }
}
