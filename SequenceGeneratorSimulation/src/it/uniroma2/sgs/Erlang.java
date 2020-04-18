package it.uniroma2.sgs;

/**
 * Distribuzione erlangiana
 * @author xx YY
 *
 */
public class Erlang extends Distribuzione{

	private double ts;
	private int k;
	
	/**
	 * @param rand Generatore moltiplicativo
	 * @param ts parametro ts
	 * @param k numero di stazioni
	 */
	public Erlang(GeneratoreMoltiplicativo rand, double ts, int k) {
		super.rand = rand;
		this.ts = ts;
		this.k = k;
	}
	
	/**
	 * @return IL prossimo valore della sequenza
	 */
	public double get_next() {
		double p;
		do {
			p=1;
			for (int i = 0; i<k;i++) {
				p=p*rand.get_next_in_01();
			}
			} while (p==0);
		return ((-ts / k) * Math.log(p));
	}
}
