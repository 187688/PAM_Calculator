package pl.p.lodz.calculator;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class CalcActivity extends Activity implements OnClickListener{
	
	private double result = 0.0;
	private CalcNumber tempValue = new CalcNumber("0");
	private Operator operator = Operator.DEFAULT;
	
	private TextView tempText;
	private TextView operatorText;
	private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        CalcButtons.initializeSimplyCalcButtons(this);
        
        tempText = (TextView) findViewById(R.id.tempText);
        operatorText = (TextView) findViewById(R.id.operatorText);
        resultText = (TextView) findViewById(R.id.resultText);
    }
    
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
    	super.onConfigurationChanged(newConfig);
    	if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
    		CalcButtons.initializeExtendedCalcButtons(this);
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
			addToTempValue(CalcButtons.DOT);
			break;
			
		case R.id.ButtonAC:
			clear();
			break;
			
		case R.id.ButtonAdd:
			calculate(Operator.ADD);
			break;
		case R.id.ButtonSub:
			calculate(Operator.SUBTRACT);
			break;
		case R.id.ButtonMul:
			calculate(Operator.MULTIPLY);
			break;
		case R.id.ButtonDiv:
			calculate(Operator.DIVIDE);
			break;
		case R.id.ButtonEq:
			calculate(Operator.EQUATION);
			break;
			
		case R.id.ButtonBkspc:
			backspace();
			break;
		case R.id.ButtonNeg:
			tempValue.negate();
			setTempText(tempValue.getValue());
			break;
		}
		
	}

	private void backspace() {
		// We don't want to delete firstZero
		String value = tempValue.getValue();
		if (tempValue.isNegative() && value.length() == 2) {
			setTempText("-0");
			return;
		}
		if (!tempValue.isNegative() && value.length() == 1) {
			setTempText("0");
			return;
		}
		setTempText(value.substring(0, value.length()-1));
	}


	private void clear() {
		setResult(0.0);
		setTempText("0");
		setOperator(Operator.DEFAULT);
	}
	
	/**
	 * Before setting new operator we must do operation with last operator
	 * @param operator
	 */
	private void calculate(Operator operator) {
		if (this.operator == Operator.DEFAULT) {
			setResult(Double.parseDouble(tempValue.getValue()));
			setOperator(operator);
		} else if (Operator.EQUATION.equals(operator)) {
			makeEquation();
		} else {
			makeOperation();
			setResult(result);
			setOperator(operator);
		}
		setTempText("0");
	}
	
	private void makeOperation() {
		switch (operator) {
		case ADD:
			result += Double.parseDouble(tempValue.getValue());
			break;
		case SUBTRACT:
			result -= Double.parseDouble(tempValue.getValue());
			break;
		case MULTIPLY:
			result *= Double.parseDouble(tempValue.getValue());
			break;
		case DIVIDE:
			double val = Double.parseDouble(tempValue.getValue());
			if (val == 0.0) { 
				Toast.makeText(this, "Nie dziel przez 0!", Toast.LENGTH_SHORT).show();
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
		setTempText("0");
		setResult(result);
		setOperator(Operator.DEFAULT);
	}

	private void addToTempValue(String sign) {
		// There cannot be duplicated 0 on the beggining
		if (tempValue.isZeroFirst() && "0".equals(sign)) {
			return;
		}

		// There cannot be double dots in number
		if (CalcButtons.DOT.equals(sign) && tempValue.getValue().contains(CalcButtons.DOT)) {
			return;
		} 
		
		// If we have empty string and we will put dot, first must be a 0
		if (CalcButtons.DOT.equals(sign) && tempValue.isZeroFirst()) {
			setTempText(tempValue.isNegative() ? "-0." : "0.");
			return;
		}
		
		// If we have 0 on the beggining and try to append number
		if (tempValue.isZeroFirst() && tempValue.isNegative()) {
			setTempText("-" + sign);
			return;
		} else if (tempValue.isZeroFirst() && !tempValue.isNegative()) {
			setTempText(sign);
			return;
		}
		
		String appendix = tempValue.getValue();
		setTempText(appendix += sign);
	}
	
	/*
	 * SETTERS TO FIELDS AND VIEWS 
	 */
	
    private void setResult(double value) {
    	result = value;
    	resultText.setText(String.valueOf(value));
    }
    
    private void setOperator(Operator operator) {
    	if (operator == Operator.EQUATION) {
    		return;
    	}
    	this.operator = operator;
    	operatorText.setText(operator == null ? "" : operator.label);
    }
    
    private void setTempText(String value) {
    	tempValue.setValue(value);
		tempText.setText(value);
    }
}
