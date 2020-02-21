package com.accenture.training.anddemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;


import java.util.ArrayList;

public class ExpenseActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spCategory;
    EditText etTitle, etAmount;
    Button btnSave;
    RadioGroup rgDC;
    ArrayList<String> alCat;
    Expense expense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
        spCategory = (Spinner) findViewById(R.id.ae_sp_category);
        etTitle = (EditText) findViewById(R.id.ae_et_title);
        etAmount = (EditText) findViewById(R.id.ae_et_amount);
        btnSave = (Button) findViewById(R.id.ae_btn_save);
        rgDC = (RadioGroup) findViewById(R.id.ae_rg);

        expense = new Expense();

        alCat = new ArrayList<>();
        alCat.add("Home expenses");
        alCat.add("Salary Income");
        alCat.add("Gift");
        alCat.add("Medical");
        alCat.add("Transport");

        ArrayAdapter aaCat = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line, alCat);
        spCategory.setAdapter(aaCat);
        spCategory.setOnItemSelectedListener(this);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                expense.title = etTitle.getText().toString();
                expense.amount = Integer.parseInt(etAmount.getText().toString());
                int checkedId = rgDC.getCheckedRadioButtonId();
//                RadioButton rbSelected = (RadioButton) findViewById(checkedId);
                if(checkedId == R.id.ae_rg_credit) {
                    expense.isCredit =true;
                } else {
                    expense.isCredit = false;
                }

                Log.i("Expense", expense.toString());
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        expense.category = alCat.get(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        expense.category = "Other";
    }
}
