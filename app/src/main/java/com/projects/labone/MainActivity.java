package com.projects.labone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView fromTextView;
    TextView toTextView;
    TextView valueTextView;
    EditText enterValue;
    Spinner spinnerOne;
    Spinner spinnerTwo;
    Button convertButton;
    TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterValue = (EditText) findViewById(R.id.enterValue);
        convertButton = (Button) findViewById(R.id.button);
        results =(TextView) findViewById(R.id.resultTextView);
        spinnerOne =(Spinner) findViewById(R.id.spinner1);
        spinnerTwo = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOne.setAdapter(adapter);
        spinnerTwo.setAdapter(adapter);


        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             double value;
             double result;
             String choice1 = spinnerOne.getSelectedItem().toString();
             String choice2 = spinnerTwo.getSelectedItem().toString();

             if(enterValue.getText().toString().isEmpty()){
                 Toast.makeText(getApplicationContext(), "Please Enter Value to be Converted", Toast.LENGTH_LONG).show();

             }

             else if((choice1.equals("EGP") && choice2.equals("EGP")) || (choice1.equals("USD") && choice2.equals("USD"))){
                 Toast.makeText(getApplicationContext(), "Please Enter Different Values to be Converted", Toast.LENGTH_LONG).show();

             }

             else if(choice1.equals("EGP") && choice2.equals("USD")){
                 result = Integer.parseInt(enterValue.getText().toString()) / 17.6;
                 String finalResult = String.format("%.2f", result);
                 results.setText("The Result is " + finalResult + " $");
             }

               else if(choice1.equals("USD") && choice2.equals("EGP")){
                    result = 17.6 * Integer.parseInt(enterValue.getText().toString());
                 String finalResult = String.format("%.2f", result);
                 results.setText("The Result is " + finalResult + " L.E");
                }



            }
        });
    }
}
