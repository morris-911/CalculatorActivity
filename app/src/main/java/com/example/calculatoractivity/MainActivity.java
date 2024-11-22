package com.example.calculatoractivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_result;
    private String firstNum="";
    private String operator="";
    private String seconNum="";
    private String result="";
    private String showtext="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tv_result = findViewById(R.id.tv_result);
        findViewById(R.id.btn_cancle).setOnClickListener(this);
        findViewById(R.id.btn_divide).setOnClickListener(this);
        findViewById(R.id.btn_multply).setOnClickListener(this);
        findViewById(R.id.btn_clear).setOnClickListener(this);
        findViewById(R.id.btn_seven).setOnClickListener(this);
        findViewById(R.id.btn_eight).setOnClickListener(this);
        findViewById(R.id.btn_nine).setOnClickListener(this);
        findViewById(R.id.btn_plus).setOnClickListener(this);
        findViewById(R.id.btn_four).setOnClickListener(this);
        findViewById(R.id.btn_five).setOnClickListener(this);
        findViewById(R.id.btn_six).setOnClickListener(this);
        findViewById(R.id.btn_minus).setOnClickListener(this);
        findViewById(R.id.btn_one).setOnClickListener(this);
        findViewById(R.id.btn_two).setOnClickListener(this);
        findViewById(R.id.btn_three).setOnClickListener(this);
        findViewById(R.id.btn_reciprocal).setOnClickListener(this);
        findViewById(R.id.btn_root).setOnClickListener(this);
        findViewById(R.id.btn_zero).setOnClickListener(this);
        findViewById(R.id.btn_dot).setOnClickListener(this);
        findViewById(R.id.btn_equal).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String inputText;

        if(view.getId() == R.id.btn_root){
            inputText = "√";
        }else {
            inputText = ((TextView)view).getText().toString();
        }
        if(view.getId() == R.id.btn_clear){
                clear();
        }else if(view.getId() == R.id.btn_plus){
            operator = inputText;
            refreshText(showtext + operator);
        }else if(view.getId() == R.id.btn_minus){
            operator = inputText;
            refreshText(showtext + operator);
        }else if(view.getId() == R.id.btn_multply){
            operator = inputText;
            refreshText(showtext + operator);
        }else if(view.getId() == R.id.btn_divide){
            operator = inputText;
            refreshText(showtext + operator);
        }else if(view.getId() == R.id.btn_equal){
            double calculate_result = calculateFour();
            refreshOperate(String.valueOf(calculate_result));
            refreshText(showtext + "=" +result);
        }else if(view.getId() == R.id.btn_reciprocal){
            double reciprocal_result = 1 / Double.parseDouble(firstNum);
            refreshOperate(String.valueOf(reciprocal_result));
            refreshText( "1/"+showtext+"="+result);
        }else if(view.getId() == R.id.btn_root){
            double sqrt_result = Math.sqrt(Double.parseDouble(firstNum));
            refreshOperate(String.valueOf(sqrt_result));
            refreshText(showtext + "√=" +result);
        }else{
            if(result.length() > 0 && operator.equals("")){
                clear();
            }
            if(operator.equals("")){
                firstNum += inputText;
            }else{
                seconNum += inputText;
            }
            if(showtext.equals("0")&&!inputText.equals(".")){
                refreshText(inputText);
            }else {
                refreshText(showtext + inputText);
            }
        }

    }

    private double calculateFour() {
        if(operator.equals("+")){
            return plus(firstNum,seconNum);
        }else if(operator.equals("-")){
            return minus(firstNum,seconNum);
        }else if(operator.equals("x")){
            return multiply(firstNum,seconNum);
        }else if(operator.equals("÷")){
            return divide(firstNum,seconNum);
        }else if(operator.equals("")) {
            return Double.parseDouble(firstNum);
        }else return 0;

    }

    private void refreshText(String text){
        showtext = text;
        tv_result.setText(showtext);
    }
    private void clear(){
        refreshText("0");
        refreshOperate("");
    }
    private void refreshOperate(String new_result){
        result = new_result;
        firstNum = new_result;
        seconNum ="";
        operator ="";
    }
    private double plus(String num1,String num2){
        return Double.parseDouble(num1) + Double.parseDouble(num2);
    }
    private double minus(String num1,String num2){
        return Double.parseDouble(num1) - Double.parseDouble(num2);
    }
    private double multiply(String num1,String num2){
        return Double.parseDouble(num1) * Double.parseDouble(num2);
    }
    private double divide(String num1,String num2){
        return Double.parseDouble(num1) / Double.parseDouble(num2);
    }
}

