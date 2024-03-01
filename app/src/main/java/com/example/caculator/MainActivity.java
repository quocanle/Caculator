package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    private TextView tvSolution, tvResult;
    private MaterialButton buttonC, buttonOpenBracket, buttonCloseBracket;
    private MaterialButton buttonPlus, buttonMinus, buttonDivide, buttonMulti, buttonEquals;
    private MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private MaterialButton buttonAC, buttonDot;
    private String solutionText ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tv_result);
        tvSolution = findViewById(R.id.tv_solution);

        buttonC = findViewById(R.id.button_c);
        buttonOpenBracket = findViewById(R.id.button_open_bracket);
        buttonCloseBracket = findViewById(R.id.button_close_bracket);
        buttonPlus = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        buttonMulti = findViewById(R.id.button_multi);
        buttonDivide = findViewById(R.id.button_divide);
        buttonEquals = findViewById(R.id.button_equals);
        buttonAC = findViewById(R.id.button_ac);
        buttonDot = findViewById(R.id.button_dot);
        button0 = findViewById(R.id.button_0);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!solutionText.isEmpty()) {
                    solutionText = solutionText.substring(0, solutionText.length() - 1);
                    tvSolution.setText(solutionText);
                    if (solutionText.length() == 0) {
                        tvSolution.setText("0");
                    }
                } else {
                    tvSolution.setText("0");
                }
            }
        });
        buttonOpenBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToSolution("(");
            }
        });
        buttonCloseBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToSolution(")");
            }
        });
        //
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToSolution("+");
            }
        });
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToSolution("-");
            }
        });
        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToSolution("*");
            }
        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToSolution("/");
            }
        });
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText(calculate(solutionText));
            }
        });
        //
        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solutionText = "";
                tvSolution.setText("0");
                tvResult.setText("0");
            }
        });
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToSolution(".");
            }
        });
        //
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToSolution("0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToSolution("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToSolution("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToSolution("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToSolution("4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToSolution("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToSolution("6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToSolution("7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToSolution("8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToSolution("9");
            }
        });
    }

    public void addToSolution(String add) {
        solutionText = solutionText + add;
        tvSolution.setText(solutionText);
    }

    public String calculate(String solutionText) {
        String dataCalculate = solutionText;
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable, dataCalculate, "Javascript", 1, null).toString();
            return finalResult;
        } catch (Exception ex) {
            return "Err";
        }
    }
}