package fr.cesi.java.exo4;

public class Terme implements Solvable {

	private double value;

	public Terme(String value) {
		try {
			this.value = Double.parseDouble(value);
		}
		catch (Throwable t) {
			System.err.println("Invalid terme: " + value);
			throw new RuntimeException(t);
		}
	}

	@Override
	public double solve() {
		return value;
	}

}
