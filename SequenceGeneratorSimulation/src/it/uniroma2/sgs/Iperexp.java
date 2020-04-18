package it.uniroma2.sgs;
/**
 * Distribuzione Iperesponenziale
 * @author xx YY
 *
 */
public class Iperexp extends Distribuzione{

	private double ta;
	private double p;
	private Esponenziale exp;
	
	/**
	 * 
	 * @param rand Generatore moltiplicativo
	 * @param ta Parametro ta
	 * @param p Probabilità p
	 */
	public Iperexp(GeneratoreMoltiplicativo rand, double ta, double p) {
		super.rand = rand;
		this.ta = ta;
		this.p = p;
		exp = new Esponenziale(rand, 1);
	}
	
	/**
	 * @return Il prossimo valore della distribuzione Iperesponenziale
	 */
	public double get_next() {
		double r_exp = exp.get_next();
		double r = rand.get_next_in_01();
		if (r>p) {
			return r_exp*(ta/(2*(1-p)));
		}
		else {
			return r_exp*(ta/(2*p));
		}
	}
}
