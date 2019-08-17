package com.example.weatherappweekendassignment.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.weatherappweekendassignment.R;

public class MainActivity extends AppCompatActivity {

    EditText etZip;
    Button btnSave;
    RadioButton rbFar, rbCel, rbKel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etZip = findViewById(R.id.et_zipcode);
        btnSave = findViewById(R.id.btn_save);
        rbFar = findViewById(R.id.rb_fahrenheit);
        rbCel = findViewById(R.id.rb_celsius);
        rbKel = findViewById(R.id.rb_kelvin);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String unit = null;
                Boolean unitSelected = true;
                if (etZip.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter a zipcode!", Toast.LENGTH_SHORT).show();
                } else {
                    if (rbFar.isChecked()) {
                        unit = "fahrenheit";
                    } else if (rbCel.isChecked()) {
                        unit = "celsius";
                    } else if (rbKel.isChecked()) {
                        unit = "kelvin";
                    } else {
                        Toast.makeText(MainActivity.this, "Select unit!", Toast.LENGTH_SHORT).show();
                        unitSelected = false;
                    }
                    if (unitSelected.equals(true)) {
                        Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                        intent.putExtra("zip", etZip.getText().toString());
                        intent.putExtra("unit", unit);
                        setResult(RESULT_OK, intent);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
