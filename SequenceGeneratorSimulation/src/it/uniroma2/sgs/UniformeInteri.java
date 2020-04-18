package it.uniroma2.sgs;

/**
 * 
 * @author xx YY
 *
 */
public class UniformeInteri extends Distribuzione{

	private int a;
	private int b;
	
	/**
	 * 
	 * @param rand Generatore moltiplicativo
	 * @param a parametro inf
	 * @param b parametro sup
	 */
	public UniformeInteri(GeneratoreMoltiplicativo rand, int a, int b) {
		super.rand = rand;
		this.a = a;
		this.b = b;
	}
	
	/**
	 * @return il prossimo valore della distribuzione uniforme
	 */
	public int get_next() {
		double adjusted = rand.get_next_in_01() * (b -a) + a;
		return (int)Math.floor(adjusted);
	}
	
	/**
	 * @return il prossimo valore della distribuzione uniforme
	 */
	public double get_next_double() {
		return rand.get_next_in_01() * (b -a) + a; 
	}
}
