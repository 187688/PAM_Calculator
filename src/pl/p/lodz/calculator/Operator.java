package pl.p.lodz.calculator;

public enum Operator {

	ADD("+"),
	SUBTRACT("-"),
	MULTIPLY("x"),
	DIVIDE("/"),
	EQUATION("="),
	EXPONENTIATION("^"),
	DEFAULT("");
	
	String label;
	
	private Operator(String operator) {
		this.label = operator;
	}
	
}
