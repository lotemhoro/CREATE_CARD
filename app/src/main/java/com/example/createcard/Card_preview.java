package com.example.createcard;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Card_preview extends AppCompatActivity {

    LinearLayout ll;
    TextView t_name, t_role;
    ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_preview);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String role = intent.getStringExtra("role");
        boolean isDarkMode = intent.getBooleanExtra("mode", false);
        String style = intent.getStringExtra("style");

        ll = findViewById(R.id.ll);
        t_name = findViewById(R.id.t_name);
        t_role = findViewById(R.id.t_role);
        btn_back = findViewById(R.id.btn_back);

        if(isDarkMode)
            ll.setBackgroundColor(Color.BLACK);
        t_name.setText(name);
        t_role.setText(role);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Card_preview.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}