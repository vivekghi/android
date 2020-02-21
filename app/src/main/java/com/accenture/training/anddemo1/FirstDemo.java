package com.accenture.training.anddemo1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FirstDemo extends AppCompatActivity {

    Button btnChange;
    Button btngo;
    TextView tvCompany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_demo);

        btnChange= findViewById(R.id.afd_btn_change);
        btngo=findViewById(R.id.afd_btn_go);
        tvCompany = findViewById(R.id.tvCompany);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String company=tvCompany.getText().toString();
               // Toast.makeText(FirstDemo.this, company, Toast.LENGTH_SHORT).show();
                showAlert("First Demo", "Company name chaned");
                //tvCompany.setText("IBM");
            }
        });
        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstDemo.this,ExplicitIntentDemo.class);
                intent.putExtra("country_name","India");
                FirstDemo.this.startActivityForResult(intent,1001);
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==1001) {
            if(resultCode==RESULT_OK) {
                String compName = data.getStringExtra("company_name");
                tvCompany.setText(compName);
            }
        }
    }

    void showAlert(String title, String msg) {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch(which){
                    case DialogInterface.BUTTON_POSITIVE:
                        // User clicked the Yes button
                        tvCompany.setText("IBM");
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        // User clicked the No button
                        break;
                }
            }
        };
        AlertDialog.Builder builder  = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton("Ok",dialogClickListener);
        builder.setNegativeButton("No",dialogClickListener);
        builder.setNeutralButton("Cancel",dialogClickListener);
        AlertDialog alertDialog = builder.create();

        alertDialog.show();;



    }
}
