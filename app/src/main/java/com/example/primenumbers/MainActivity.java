package com.example.primenumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b_generate;
    EditText et_number1, et_number2;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_generate = findViewById(R.id.b_generate);

        et_number1 = findViewById(R.id.et_number1);
        et_number2 = findViewById(R.id.et_number2);

        tv_result = findViewById(R.id.tv_result);

        b_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Getting both the number inputs
                int num1 = Integer.parseInt(et_number1.getText().toString());
                int num2 = Integer.parseInt(et_number2.getText().toString());

                // Displaying result
                String result = getPrimeNumbers(num1, num2);
                tv_result.setText(result);

            }
        });

    }

    public String getPrimeNumbers(int num1, int num2) {

        int min, max;
        String result = "";

        if (num1 == num2) {
            return "Haha! Nice Prank.";
        }
        else if (num1 > num2) {
            max = num1;
            min = num2;
        }
        else {
            max = num2;
            min = num1;
        }

        for (int i = min; i <= max; i++) {

            // Handling for 1 and 2
            if (i == 1) {
                continue;
            }
            if (i == 2) {
                result += i+" ";
                continue;
            }

            // Normal
            if (isPrime(i))
                result += i+" ";

        }

        return result;
    }

    public boolean isPrime(int n) {

        boolean prime = true;

        for (int i = 2; i <= (n/2)+1; i++) {

            if (n%i == 0) {
                prime = false;
                break;
            }
        }

        return prime;
    }

}