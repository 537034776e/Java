package it.uniroma2.sgs;


/**
 * Distribuzione Gaussiana
 * @author xx YY 
 *
 */
public class Gaussiana extends Distribuzione{

	private double media;
	private double var;
	
	/**
	 * @param rand Generatore moltiplicativo
	 * @param media Parametro media
	 * @param var Parametro Varianza
	 */
	public Gaussiana(GeneratoreMoltiplicativo rand, double media, double var) {
		super.rand = rand;
		this.media = media;
		this.var = Math.sqrt(var);
	}
	
	/**
	 * 
	 * @return Il prossimo valore della distribuzione Gaussiana
	 */
	public double get_next() {
		//Limita ai valori positivi
		double gauss = this.get_next_gauss();
		while (gauss<0 || gauss > 2*media)
		{			
			gauss = this.get_next_gauss();
			
		}
		return gauss;
	}

	/**
	 * Non limitata ai valori positivi
	 * @return
	 */
	private double get_next_gauss() {
		double sum = 0;
		for (int i = 0; i<13; i++) {
			sum += rand.get_next_in_01();
		}
		return var * (sum - 6.0) + media;
	}
}
