package it.uniroma2.sts;

/***
 * 
 * @author xx YY Generatore moltiplicativo di sequenze casuali
 */
public class GeneratoreMoltiplicativo {
	private int seme;
	private int a;
	private int m;
	long last_value;

	/**
	 * @param seme Il seme della sequenza random
	 * @param a    Il moltiplicatore della sequenza random
	 * @param m    il modulo della sequenza random
	 */
	public GeneratoreMoltiplicativo(int seme, int a, int m) {
		this.seme = seme;
		this.a = a;
		this.m = m;

		this.last_value = seme;
	}

	/**
	 * 
	 * @return Il valore del prossimo elemento nella sequenza casuale
	 */
	public long get_next() {
		long toRet = last_value;
		last_value = (a * last_value) % m;
		return toRet;
	}

	/**
	 * @return IL valore del prossimo elemento nella sequenza casuale
	 *         nell'intervallo [0,1)
	 */
	public double get_next_in_01() {
		return ((double) get_next() / (double) m);
	}

	/***
	 * Reset della sequenza random
	 */
	public void reset() {
		last_value = seme;
	}
}

