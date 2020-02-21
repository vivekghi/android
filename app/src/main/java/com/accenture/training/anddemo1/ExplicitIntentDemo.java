package com.accenture.training.anddemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExplicitIntentDemo extends AppCompatActivity {
    private TextView tv;
    private Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent_demo);
        tv = findViewById(R.id.aei_tv_country);
        btnClose = findViewById(R.id.ael_btn_close);
        Intent i = getIntent();
        String countryName = i.getStringExtra("country_name");
        tv.setText(countryName);

        btnClose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent inte = new Intent();
                inte.putExtra("company_name", "Infy");
                setResult(RESULT_OK,inte);
                finish();
            }

        });

    }
}
