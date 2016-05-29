package pl.p.lodz.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class CalcActivity extends Activity implements OnClickListener{
	
	private static final String DOT = ".";
	
	private double result = 0.0;
	private String tempValue = "";
	private Operators operator;
	
	TextView tempText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        CalcButtons.initializeButtons(this);
        tempText = (TextView) findViewById(R.id.tempText);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calc, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		onClickAction(v.getId());
	}

	private void onClickAction(int id) {
		switch(id) {
		case R.id.Button0:
			addToTempValue("0");
			break;
		case R.id.Button1:
			addToTempValue("1");
			break;
		case R.id.Button2:
			addToTempValue("2");
			break;
		case R.id.Button3:
			addToTempValue("3");
			break;
		case R.id.Button4:
			addToTempValue("4");
			break;
		case R.id.Button5:
			addToTempValue("5");
			break;
		case R.id.Button6:
			addToTempValue("6");
			break;
		case R.id.Button7:
			addToTempValue("7");
			break;
		case R.id.Button8:
			addToTempValue("8");
			break;
		case R.id.Button9:
			addToTempValue("9");
			break;
		case R.id.ButtonDot:
			addToTempValue(DOT);
			break;
			
		case R.id.ButtonAC:
			clear();
			break;
			
		case R.id.ButtonAdd:
			calculate(Operators.ADD);
			break;
		case R.id.ButtonSub:
			calculate(Operators.SUBTRACT);
			break;
		case R.id.ButtonMul:
			calculate(Operators.MULTIPLY);
			break;
		case R.id.ButtonDiv:
			calculate(Operators.DIVIDE);
			break;
		case R.id.ButtonEq:
			calculate(Operators.EQUATION);
			break;
		}
		
	}
	
	private void clear() {
		result = 0.0;
		tempValue = "";
		operator = null;
		tempText.setText("0");
	}
	
	private void calculate(Operators operator) {
		if (this.operator == null) {
			result = Double.parseDouble(tempValue);
			tempValue = "";
			tempText.setText("");
			this.operator = operator;
		}else if (Operators.EQUATION.equals(operator)) {
			makeEquation();
		} else if (tempText.getText().length() == 0) {
			this.operator = operator;
		}else {
			makeOperation();
			this.operator = operator;
		}
	}
	
	private void makeOperation() {
		switch (operator) {
		case ADD:
			result += Double.parseDouble(tempValue);
			break;
		case SUBTRACT:
			result -= Double.parseDouble(tempValue);
			break;
		case MULTIPLY:
			result *= Double.parseDouble(tempValue);
			break;
		case DIVIDE:
			double val = Double.parseDouble(tempValue);
			if (val == 0.0) { 
				clear();
				//TODO: Add alert
				break;
			} 
			result /= val;
			break;
		default:
			break;
		}
	}


	private void makeEquation() {
		makeOperation();
		tempValue = String.valueOf(result);
		tempText.setText(tempValue);
		result = 0.0;
		operator = null;
	}


	private void addToTempValue(String value) {
		if (DOT.equals(value) && tempValue.contains(DOT)) {
			// There cannot be double dots in number
			return;
		} 
		if (DOT.equals(value) && tempValue.isEmpty()) {
			// If we have empty string and we will put dot, first must be a 0
			tempValue = "0.";
			tempText.setText(tempValue);
			return;
		}
		tempValue += value;
		tempText.setText(tempValue);
	}
	
    
}
