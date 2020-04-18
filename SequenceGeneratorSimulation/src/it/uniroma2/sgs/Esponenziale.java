package it.uniroma2.sgs;

/**
 * Generatore distribuzione esponenziale
 * @author xx YY
 *
 */
public class Esponenziale extends Distribuzione{

	private double ta;
	
	/**
	 * 
	 * @param rand Generatore moltiplicativo
	 * @param ta Parametro ta
	 */
	public Esponenziale(GeneratoreMoltiplicativo rand, double ta) {
		super.rand = rand;
		this.ta = ta;
	}
	
	/**
	 * 
	 * @return Il prossimo valore della sequenza Esponenziale
	 */
	public double get_next() {
		return -ta * Math.log(rand.get_next_in_01());
	}
}
