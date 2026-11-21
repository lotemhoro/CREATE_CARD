package com.example.createcard;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    ImageButton btnLeft, btnProfile, btnRight;
    EditText etName, etRole;
    RadioGroup rg;
    Switch sw;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLeft = findViewById(R.id.btn_left);
        btnProfile = findViewById(R.id.btn_profile);
        btnRight = findViewById(R.id.btn_right);
        etName = findViewById(R.id.et_name);
        etRole = findViewById(R.id.et_role);
        rg = findViewById(R.id.RG);
        sw = findViewById(R.id.sw);
        btnNext = findViewById(R.id.btn_next);

        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = etName.getText().toString();
                String role = etRole.getText().toString();
                Boolean dark_mode = sw.isChecked();

                String style = "Modern";
                int checkedId = rg.getCheckedRadioButtonId();
                if (checkedId == R.id.rb1) {
                    style = "Classic";
                } else if (checkedId == R.id.rb3) {
                    style = "Colorful";
                }

                intent = new Intent(MainActivity.this, Card_preview.class);
                intent.putExtra("name", name);
                intent.putExtra("role", role);
                intent.putExtra("mode", dark_mode);
                intent.putExtra("style", style);
                startActivity(intent);
            }
        });
    }
}