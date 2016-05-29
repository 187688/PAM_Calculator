package pl.p.lodz.calculator;

public enum Operators {

	ADD("+"),
	SUBTRACT("-"),
	MULTIPLY("x"),
	DIVIDE("/"),
	EQUATION("=");
	
	String operator;
	
	private Operators(String operator) {
		this.operator = operator;
	}
	
}
