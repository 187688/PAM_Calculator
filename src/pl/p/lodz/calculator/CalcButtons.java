package pl.p.lodz.calculator;

import android.view.View.OnClickListener;
import android.widget.Button;

public class CalcButtons {

	public static final String DOT = ".";
	
	public static Button btn1; 
	public static Button btn2;
	public static Button btn3;
	public static Button btn4; 
	public static Button btn5;
	public static Button btn6;
	public static Button btn7; 
	public static Button btn8;
	public static Button btn9;
	public static Button btn0;
	
	public static Button btnEq;
	public static Button btnAdd;
	public static Button btnSub; 
	public static Button btnMul;
	public static Button btnDiv;
	
	public static Button btnDot; 
	public static Button btnAC;
	public static Button btnNeg; 
	public static Button btnBkspc;
	
	public static Button btnLog;
	public static Button btnLn;
	public static Button btnInv;
	public static Button btnSqrt;
	public static Button btnPer;
	public static Button btnCub;
	public static Button btnSqrd;
	public static Button btnExp;
	
	public static void initializeSimplyCalcButtons(CalcActivity activity) {
		btn1 = (Button) activity.findViewById(R.id.Button1);
		btn2 = (Button) activity.findViewById(R.id.Button2);
		btn3 = (Button) activity.findViewById(R.id.Button3);
		btn4 = (Button) activity.findViewById(R.id.Button4);
		btn5 = (Button) activity.findViewById(R.id.Button5);
		btn6 = (Button) activity.findViewById(R.id.Button6);
		btn7 = (Button) activity.findViewById(R.id.Button7);
		btn8 = (Button) activity.findViewById(R.id.Button8);
		btn9 = (Button) activity.findViewById(R.id.Button9);
		btn0 = (Button) activity.findViewById(R.id.Button0);
		
		btnEq = (Button) activity.findViewById(R.id.ButtonEq);
		btnAdd = (Button) activity.findViewById(R.id.ButtonAdd);
		btnSub = (Button) activity.findViewById(R.id.ButtonSub);
		btnMul = (Button) activity.findViewById(R.id.ButtonMul);
		btnDiv = (Button) activity.findViewById(R.id.ButtonDiv);
		
		btnDot = (Button) activity.findViewById(R.id.ButtonDot);
		btnAC = (Button) activity.findViewById(R.id.ButtonAC);
		btnNeg = (Button) activity.findViewById(R.id.ButtonNeg);
		btnBkspc = (Button) activity.findViewById(R.id.ButtonBkspc);
		
		setOnClickSimplyCalcListener(activity);
	}
	
	public static void initializeExtendedCalcButtons(CalcActivity activity) {
		btnLog = (Button) activity.findViewById(R.id.ButtonLog);
		btnLn = (Button) activity.findViewById(R.id.ButtonLn);
		btnInv = (Button) activity.findViewById(R.id.ButtonInv);
		btnSqrt = (Button) activity.findViewById(R.id.ButtonSqrt);
		btnPer = (Button) activity.findViewById(R.id.ButtonPer);
		btnCub = (Button) activity.findViewById(R.id.ButtonCub);
		btnSqrd = (Button) activity.findViewById(R.id.ButtonSqrd);
		btnExp = (Button) activity.findViewById(R.id.ButtonExp);
		
		setOnClickExtendedCalcListener(activity);
	}

	private static void setOnClickSimplyCalcListener(OnClickListener listener) {
		btn1.setOnClickListener(listener);
		btn2.setOnClickListener(listener);
		btn3.setOnClickListener(listener);
		btn4.setOnClickListener(listener);
		btn5.setOnClickListener(listener);
		btn6.setOnClickListener(listener);
		btn7.setOnClickListener(listener);
		btn8.setOnClickListener(listener);
		btn9.setOnClickListener(listener);
		btn0.setOnClickListener(listener);
		
		btnEq.setOnClickListener(listener);
		btnAdd.setOnClickListener(listener);
		btnSub.setOnClickListener(listener);
		btnMul.setOnClickListener(listener);
		btnDiv.setOnClickListener(listener);
		
		btnDot.setOnClickListener(listener);
		btnAC.setOnClickListener(listener);
		btnNeg.setOnClickListener(listener);
		btnBkspc.setOnClickListener(listener);
	}
	
	private static void setOnClickExtendedCalcListener(CalcActivity listener) {
		btnLog.setOnClickListener(listener);
		btnLn.setOnClickListener(listener);
		btnInv.setOnClickListener(listener);
		btnSqrt.setOnClickListener(listener);
		btnPer.setOnClickListener(listener);
		btnCub.setOnClickListener(listener);
		btnSqrd.setOnClickListener(listener);
		btnExp.setOnClickListener(listener);
	}
}
