package com.example.printapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun printDetails(view: View) {
        val editText1 = findViewById<EditText>(R.id.textInputField) // get the element
        val textInput = editText1.text // get the text from the element
        val editText2 = findViewById<EditText>(R.id.numberInputField) // get the element
        val numberInput = editText2.text // get the text from the element

        val textPrint = findViewById<TextView>(R.id.textPrintField)
        textPrint.text = "$textInput"
        val numberPrint = findViewById<TextView>(R.id.numberPrintField)
        numberPrint.text = "$numberInput"
    }
}