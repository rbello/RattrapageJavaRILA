package fr.cesi.java.exo4;

public class Operator implements Solvable {

	private char op;

	public Operator(char c) {
		this.op = c;
	}

	@Override
	public double solve() {
		return Double.NaN;
	}

	public double execute(Solvable left, Solvable right) {
		switch (op) {
		case '+' : return left.solve() + right.solve();
		case '-' : return left.solve() - right.solve();
		case '/' : return left.solve() / right.solve();
		case '*' : return left.solve() * right.solve();
		}
		return Double.NaN;
	}

}
