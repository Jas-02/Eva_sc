package com.example.evascientificcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private TextView previousCalculation;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation = findViewById(R.id.previousCalculationView);
        display = findViewById(R.id.displayEditText);

        display.setShowSoftInputOnFocus(false);


    }

    private  void updateText(String strToAdd){
        String  oldstr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldstr.substring(0, cursorPos);
        String rightStr = oldstr.substring(cursorPos);

        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());
    }

    public void zeroBTNPush(View view){updateText(getResources().getString(R.string.zeroText));}
    public void oneBTNPush(View view){updateText(getResources().getString(R.string.oneText));}
    public void twoBTNPush(View view){updateText(getResources().getString(R.string.twoText));}
    public void threeBTNPush(View view){updateText(getResources().getString(R.string.threeText));}
    public void fourBTNPush(View view){updateText(getResources().getString(R.string.fourText));}
    public void fiveBTNPush(View view){updateText(getResources().getString(R.string.fiveText));}
    public void sixBTNPush(View view){updateText(getResources().getString(R.string.sixText));}
    public void sevenBTNPush(View view){updateText(getResources().getString(R.string.sevenText));}
    public void eightBTNPush(View view){updateText(getResources().getString(R.string.eightText));}
    public void nineBTNPush(View view){updateText(getResources().getString(R.string.nineText));}

    public void addBTNPush(View view){updateText(getResources().getString(R.string.addText));}
    public void subsBTNPush(View view){updateText(getResources().getString(R.string.subtractText));}
    public void mulBTNPush(View view){updateText(getResources().getString(R.string.multiplyText));}
    public void diviBTNPush(View view){updateText(getResources().getString(R.string.divideText));}
    public void deciBTNPush(View view){updateText(getResources().getString(R.string.decimalText));}

    public void parOpenBTNPush(View view){updateText(getResources().getString(R.string.parenthesesOpenText));}
    public void parCloseBTNPush(View view){updateText(getResources().getString(R.string.parenthesesCloseText));}

    public void clearBTNPush(View view){display.setText("");
                                         previousCalculation.setText("");}

    public void equalBTNPush(View view){
        String userExp = display.getText().toString();

        previousCalculation.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.divideText),"/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText),"*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

    public void backspaceBTNPush(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }

    public void trigSinBTNPush(View view){updateText("sin(");}
    public void trigCosBTNPush(View view){updateText("cos(");}
    public void trigTanBTNPush(View view){updateText("tan(");}
    public void trigArcSinBTNPush(View view){updateText("arcsin(");}
    public void trigArcCosBTNPush(View view){updateText("arccos(");}
    public void trigArcTanBTNPush(View view){updateText("arctan(");}
    public void naturalLogBTNPush(View view){updateText("ln(");}
    public void LogBTNPush(View view){updateText("log(");}
    public void squareRootBTNPush(View view){updateText("sqrt(");}
    public void absoluteValueBTNPush(View view){updateText("abs(");}
    public void piBTNPush(View view){updateText("pi");}
    public void eBTNPush(View view){updateText("e");}
    public void xsquareBTNPush(View view){updateText("^(2)");}
    public void xPowerYBTNPush(View view){updateText("^(");}
    public void primeBTNPush(View view){updateText("ispr");}


}