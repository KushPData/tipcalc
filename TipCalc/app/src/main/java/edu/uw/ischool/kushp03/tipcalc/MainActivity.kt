package edu.uw.ischool.kushp03.tipcalc

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import android.text.TextWatcher
import android.text.Editable


class MainActivity : AppCompatActivity() {
    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editServiceCharge:EditText = findViewById(R.id.editServiceCharge)
        val tipButton:Button = findViewById(R.id.tipButton)

        editServiceCharge.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                tipButton.isEnabled = editServiceCharge.text.toString() != ""
            }
        })

        tipButton.setOnClickListener {
            val serviceCharge = editServiceCharge.text.toString().toDouble() * 100.0
            val tip = (serviceCharge * 0.15) / 100
            val tipRoundedToTwoDecimalPlaces = String.format("%.2f", tip)
            val tipWithDollarSign = "$$tipRoundedToTwoDecimalPlaces"
            Toast.makeText(this, tipWithDollarSign, Toast.LENGTH_SHORT).show()
        }
    }
}