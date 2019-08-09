package com.jatin.studentms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    EditText txtUid,txtSname,txtMobile;
    TextView txtResult;
    Button btnRegister;
    HashMap<String,Student> students;
    ArrayAdapter<String> adapter;
    ArrayList<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<>();
        data.add("Select UID..");
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                data);
//        data.add("Select UID..");


        students = new HashMap<>();
        spinner = findViewById(R.id.spinner);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position>0)
                {
                Student s = students.get(data.get(position));
                String name = s.getSname();
                String mobile = s.getMnumber().toString();
                txtResult.setText("UID: "+data.get(position)
                                    +"\nName: "+name
                                    +"\nMobile: "+mobile);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        txtUid = findViewById(R.id.txtUid);
        txtSname = findViewById(R.id.txtSname);
        txtMobile = findViewById(R.id.txtMobile);
        txtResult = findViewById(R.id.txtResult);
        btnRegister = findViewById(R.id.btnAdd);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
             String n= txtSname.getText().toString();
             Long mob = Long.parseLong(txtMobile.getText().toString());
             String uid = txtUid.getText().toString();

             students.put(uid,new Student(n,mob));
             data.add(uid);

Toast.makeText(MainActivity.this,"Registered..",Toast.LENGTH_SHORT).show();
txtMobile.setText("");
txtSname.setText("");
txtUid.setText("");
                txtUid.requestFocus();
            }
        });

    }
}
