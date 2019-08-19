package com.example.weatherappweekendassignment.view;


import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.weatherappweekendassignment.R;

import static com.example.weatherappweekendassignment.view.UserSelectionUtil.UNIT;
import static com.example.weatherappweekendassignment.view.UserSelectionUtil.ZIP;


public class UserSettingsActivity extends AppCompatActivity {

    EditText etZip;
    Button btnSave;
    RadioButton rbFar, rbCel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);
        etZip = findViewById(R.id.et_zipcode);
        btnSave = findViewById(R.id.btn_save);
        rbFar = findViewById(R.id.rb_fahrenheit);
        rbCel = findViewById(R.id.rb_celsius);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String unit = null;
                Boolean unitSelected = true;
                if (etZip.getText().toString().isEmpty()) {
                    Toast.makeText(UserSettingsActivity.this, "Enter a zipcode!", Toast.LENGTH_SHORT).show();
                } else {
                    if (rbFar.isChecked()) {
                        unit = "imperial";
                    } else if (rbCel.isChecked()) {
                        unit = "metric";
                    } else {
                        Toast.makeText(UserSettingsActivity.this, "Select unit!", Toast.LENGTH_SHORT).show();
                        unitSelected = false;
                    }
                    if (unitSelected.equals(true)) {
                        Intent intent = new Intent(UserSettingsActivity.this, MainActivity.class);
                        intent.putExtra(ZIP, etZip.getText().toString());
                        intent.putExtra(UNIT, unit);
                        setResult(RESULT_OK, intent);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
