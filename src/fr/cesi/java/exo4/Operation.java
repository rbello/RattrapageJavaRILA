package fr.cesi.java.exo4;

import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;

public class Operation implements Solvable {
	
	public static void main(String[] args) {
		Operation op = new Operation("6");
		System.out.println(op + " = " + op.solve());
		op = new Operation("4+4");
		System.out.println(op + " = " + op.solve());
		op = new Operation("6/3");
		System.out.println(op + " = " + op.solve());
		op = new Operation("2*(5+4)");
		System.out.println(op + " = " + op.solve());
		op = new Operation("((2+0)*8)/4");
		System.out.println(op + " = " + op.solve());
	}

	private String txt;
	private List<Solvable> termes = new ArrayList<Solvable>();

	public Operation(String txt) throws IllegalFormatException {
		this.txt = txt;
		String subOp = null;
		String tmp = "";
		int subOpCt = 0;
		for (int i = 0, l = txt.length(); i < l; i++) {
			char c = txt.charAt(i);
			// Déclaration normale
			if (subOp == null) {
				if (c == '(') {
					// On rentre dans une sous-opération
					subOp = "";
					subOpCt++;
				}
				else if (c == '+' || c == '-' || c == '/' || c == '*') {
					if (!tmp.isEmpty()) add(new Terme(tmp));
					add(new Operator(c));
					tmp = "";
				}
				else tmp += c;
			}
			// Sous-opération
			else {
				if (c == '(') {
					subOpCt++;
					subOp += c;
				}
				else if (c == ')') {
					subOpCt--;
					if (subOpCt == 0) {
						add(new Operation(subOp));
						subOp = null;
					}
					else subOp += c;
				}
				else if (subOp != null) {
					subOp += c;
				}
			}
		}
		if (tmp.length() > 0) add(new Terme(tmp));
	}

	private void add(Solvable op) {
		termes.add(op);
	}

	public double solve() {
		double value = 0;
		if (termes.size() == 0) return 0;
		if (termes.size() == 1) return termes.get(0).solve();
		for (int i = 0; i < termes.size(); i++) {
			Solvable s = termes.get(i);
			if (s instanceof Operator) {
				value += ((Operator)s).execute(termes.get(i-1), termes.get(i+1));
				i++;
			}
		}
		return value;
	}
	
	@Override
	public String toString() {
		return txt;
	}

}
