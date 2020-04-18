package it.uniroma2.sts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/**
 */
public class Test extends GeneratoreMoltiplicativo{

    public Test(int seme, int a, int m) {
		super(seme, a, m);
		// TODO Auto-generated constructor stub
	}




    public void uniformita(int a, int x0, int b) {

        double d = 64.0;
        List<Double> rns = Utils.generaRn(a,x0,b);


        double min = Utils.calcolaChiQuadro(64.0, Utils.Z25);
        double max = Utils.calcolaChiQuadro(64.0, Utils.Z75);



        /** Z = d * rn */
        List<Double> ds = new ArrayList<Double>();
        for (Double rn : rns) {

            ds.add(Math.floor(d * rn));
        }


        int chunks = 3;
        List<List<Double>> testSet = new ArrayList<List<Double>>();
        double size = ds.size() / 3;
        for (int i = 0 ; i < chunks ; i++) {
            List<Double> chunk = new ArrayList<Double>();
            for (int j = i * (int)size ; j < (i + 1) * (int)size ; j++) {
                if (ds.get(j) > d)
                    System.out.println("j: " + j + ", add " + ds.get(j));
                chunk.add(ds.get(j));
            }
            testSet.add(chunk);
        }



        for (int k = 0 ; k < chunks ; k++) {


            Collections.sort(testSet.get(k));
            LinkedHashMap<Double, Double> freqs = new LinkedHashMap<Double, Double>();
            for (Double tmp : testSet.get(k)) {
                try {
                    freqs.put(tmp, 1.0 + freqs.get(tmp));
                } catch (Exception e) {
                    if (tmp <= 64)
                        freqs.put(tmp, 1.0);
                }
            }
            int count = 0;
            for (Double key : freqs.keySet()) {

            }
            List<Double> yss = new ArrayList<Double>();
            for (Double p : freqs.values())
                yss.add(p);
            double v = Utils.calcolaV(yss, size, 0.015625);
            if (v > min && v < max)
                System.out.println("Test eseguito con successo! " + min + " < " + v + " < " + max + " [a = " + a + "][x0 = " + x0 + "]");
            else
                System.out.println("Test fallito! " + min + " < " + v + " < " + max + " [a = " + a + "][x0 = " + x0 + "]");
            System.out.println();
        }


    }


    /***
     * test seriale
     *
     * @param a
     * @param x0
     * @param b
     */

    public void seriale(int a, int x0, int b) {
        double d = 64.0;
        int chunks = 3;
        List<List<Double>> chunksSet = createChunks(d, a, x0, b, chunks);

        double min = Utils.calcolaChiQuadro(4095.0, Utils.Z25);
        double max = Utils.calcolaChiQuadro(4095.0, Utils.Z75);

        double[][] matrix = new double[64][64];
        System.out.println("CHUNK SIZE:" + chunksSet.get(0).size());
        System.out.println("CHUNK SIZE:" + ((chunksSet.get(0).size() - 1.0) /2.0));
        for(int i=0; i < chunksSet.get(1).size() -1; i+=2) {
            try {
                matrix[chunksSet.get(1).get(i).intValue()][chunksSet.get(1).get(i+1).intValue()] += 1.0;
            } catch (Exception e) {
                matrix[chunksSet.get(1).get(i).intValue()][chunksSet.get(1).get(i+1).intValue()] = 1.0;
            }
            System.out.println("i: " + chunksSet.get(1).get(i).intValue() + " | " +  chunksSet.get(1).get(i+1).intValue() + " | " + matrix[chunksSet.get(1).get(i).intValue()][chunksSet.get(1).get(i+1).intValue()]);

        }
        printMatrix(matrix);
       
    }


    private List<List<Double>> createChunks(double d, int a, int x0, int b, int chunks ) {
        List<Double> rns = Utils.generaRn(a,x0,b);
        List<Double> ds = new ArrayList<Double>();
        for (Double rn : rns) {
            ds.add(Math.floor(d * rn));
        }

        List<List<Double>> testSet = new ArrayList<List<Double>>();
        double size = ds.size() / 3;
        System.out.println("size:"+ size);
        for (int i = 0 ; i < chunks ; i++) {
            List<Double> chunk = new ArrayList<Double>();
            for (int j = i * (int)size ; j < (i + 1) * (int)size ; j++) {
                if (ds.get(j) > d)
                    System.out.println("j: " + j + ", add " + ds.get(j));
                chunk.add(ds.get(j));
            }
            testSet.add(chunk);
        }
        return testSet;
    }

    private void printMatrix(double[][] matrix) {
        int countzero = 0;
        int  pieni = 0;
        System.out.println("--------------------");
        for(int i=63; i>= 0; i--){
            for(int j=0; j < 64; j++) {
                if ( matrix[i][j] == 0 ) {System.out.print(" "); countzero +=1;}
                else {System.out.print("O");  pieni += 1; }
            }
            System.out.println();
        }
        System.out.println("zero: " + countzero);
        System.out.println("pieni: " + pieni);
    }

}
