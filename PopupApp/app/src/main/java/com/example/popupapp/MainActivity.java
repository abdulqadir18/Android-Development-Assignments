package com.example.popupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button button1, button2, button3;
        EditText input1, input2, input3;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencing and Initializing the button
        button1 = (Button) findViewById(R.id.buttonName);
        button2 = (Button) findViewById(R.id.buttonNumber);
        button3 = (Button) findViewById(R.id.buttonEmail);

        // Referencing and Initializing the input
        input1 = (EditText) findViewById(R.id.inputName);
        input2 = (EditText) findViewById(R.id.inputNumber);
        input3 = (EditText) findViewById(R.id.inputEmail);

        // Setting onClick behavior to the button1
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the object of AlertDialog Builder class
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                // Set the message show for the Alert time
                String input1Text = input1.getText().toString();
                builder.setMessage(input1Text);

                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();
                // Show the Alert Dialog box
                alertDialog.show();
            }
        });

        // Setting onClick behavior to the button1
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the object of AlertDialog Builder class
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                // Set the message show for the Alert time
                String input2Text = input2.getText().toString();
                builder.setMessage(input2Text);

                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();
                // Show the Alert Dialog box
                alertDialog.show();
            }
        });

        // Setting onClick behavior to the button1
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the object of AlertDialog Builder class
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                // Set the message show for the Alert time
                String input3Text = input3.getText().toString();
                builder.setMessage(input3Text);

                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();
                // Show the Alert Dialog box
                alertDialog.show();
            }
        });
    }
}