package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText firstInput;
    private EditText secondInput;
    private TextView resultText;
    private Button addButton;
    private Button subtractButton;
    private Button multiplyButton;
    private Button divideButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        firstInput = findViewById(R.id.firstInput);
        secondInput = findViewById(R.id.secondInput);
        resultText = findViewById(R.id.resultText);
        addButton = findViewById(R.id.addButton);
        subtractButton = findViewById(R.id.subtractButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        divideButton = findViewById(R.id.divideButton);

    }

    public void add(View view){
        if(firstInput.getText().toString().equals("") || secondInput.getText().toString().equals("")){
            resultText.setTextColor(Color.RED);
            resultText.setText("Error. Enter both numbers.");
        }else{
            resultText.setText(Integer.toString(Integer.parseInt(firstInput.getText().toString()) + Integer.parseInt(secondInput.getText().toString())));
        }
    }
    public void subtract(View view){
        resultText.setText(Integer.toString(Integer.parseInt(firstInput.getText().toString()) - Integer.parseInt(secondInput.getText().toString())));

    }
    public void multiply(View view){
        resultText.setText(Integer.toString(Integer.parseInt(firstInput.getText().toString()) * Integer.parseInt(secondInput.getText().toString())));

    }
    public void divide(View view){
        if(Integer.parseInt(secondInput.getText().toString()) == 0){
            resultText.setTextColor(Color.RED);
            resultText.setText("Error. Attempt to divide by 0.");
        }
        else{
            resultText.setText(Integer.toString(Integer.parseInt(firstInput.getText().toString()) / Integer.parseInt(secondInput.getText().toString())));

        }
    }
}