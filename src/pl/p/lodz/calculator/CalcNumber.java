package pl.p.lodz.calculator;

public class CalcNumber {

	private String value;
	
	private boolean isNegativ = false;
	
	public CalcNumber(String value) {
		this.value = value;
	}
	
	public boolean isZeroFirst() {
		if (value.getBytes().length <= 0 || value.getBytes().length > 2) {
			return false;
		}
		return (value.getBytes()[0] == '0') ||
				(value.getBytes()[0] == '-' && value.getBytes()[1] == '0');
	}
	
	public boolean isNegative() {
		if (value.getBytes().length <= 0) {
			return false;
		}
		return value.getBytes()[0] == '-';
	}
	
	public void negate() {
		if (!isNegativ) {
			this.value = "-" + this.value;
			isNegativ = true;
		} else {
			this.value = value.substring(1, value.length());
			isNegativ = false;
		}
	}
	
	public String getValue() {return this.value;}
	
	public void setValue(String value) {this.value = value;}
}
