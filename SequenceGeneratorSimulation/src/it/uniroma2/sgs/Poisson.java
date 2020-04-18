package it.uniroma2.sgs;

/**
 * Generatore distribuzione di Poisson
 * 
 * @author xx YY
 *
 */
public class Poisson extends Distribuzione {

	private double media;
	private double t;

	private double lambda;

	/**
	 * 
	 * @param rand   Generatore moltiplicativo
	 * @param lambda Parametro della distribuzione
	 */
	public Poisson(GeneratoreMoltiplicativo rand, double media, double t) {
		super.rand = rand;
		this.media = media;
		this.t = t;

		this.lambda = this.media / this.t;
	}

	/**
	 * 
	 * @return Il prossimo valore della distribuzione di poisson
	 */
	public double get_next() {

		double n = 0;
		double e = Math.exp(-lambda * this.t);
		double p = rand.get_next_in_01();
		while (p > e) {
			p = p * rand.get_next_in_01();
			n++;
		}
		return n;
	}

}
