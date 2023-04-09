package com.example.employeedatasqliteapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.employeedatasqliteapp.DBHandler;
import com.example.employeedatasqliteapp.MainActivity;
import com.example.employeedatasqliteapp.R;

public class UpdateFormActivity extends AppCompatActivity {

    // variables for our edit text, button, strings and dbhandler class.
    private EditText NameEdt, dobEdt, salaryEdt;
    private Button updateFormBtn;
    private DBHandler dbHandler;
    String name, dob, salary;

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_form);

        // initializing all our variables.
        NameEdt = findViewById(R.id.idEdtName);
        dobEdt = findViewById(R.id.idEdtDob);
        salaryEdt = findViewById(R.id.idEdtSalary);
        updateFormBtn = findViewById(R.id.idBtnUpdateForm);

        // on below line we are initializing our dbHandler class.
        dbHandler = new DBHandler(UpdateFormActivity.this);
        Bundle extras = getIntent().getExtras();
        String values1=extras.getString("name");
        Log.d("msg",values1);
        // on below lines we are getting data which
        // we passed in our adapter class.
        id=getIntent().getIntExtra("id1",0);
        name = getIntent().getStringExtra("name");
        dob = getIntent().getStringExtra("dob");
        salary = getIntent().getStringExtra("salary");

        // setting data to edit text
        // of our update activity.
        NameEdt.setText(name);
        dobEdt.setText(dob);
        salaryEdt.setText(salary);

        // adding on click listener to our update course button.
        updateFormBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inside this method we are calling an update course
                // method and passing all our edit text values.
                dbHandler.updateForm(id, NameEdt.getText().toString(), dobEdt.getText().toString(), salaryEdt.getText().toString());

                // displaying a toast message that our course has been updated.
                Toast.makeText(UpdateFormActivity.this, "Course Updated..", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                Intent i = new Intent(UpdateFormActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
