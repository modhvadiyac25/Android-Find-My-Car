package com.example.findmycar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class EmiCalculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emi_calculator)

        val loan_amount = findViewById<TextView>(R.id.loan_amount)
        val interesr_rate = findViewById<TextView>(R.id.interesr_rate)
        val loan_tenure = findViewById<TextView>(R.id.loan_tenure)

        val btn_count_emi = findViewById<Button>(R.id.btn_count_emi)

        val loan_emi = findViewById<TextView>(R.id.loan_emi)
        val total_interest = findViewById<TextView>(R.id.total_interest)
        val total_payment = findViewById<TextView>(R.id.total_payment)

        btn_count_emi.setOnClickListener {
            val msg: String = loan_amount.text.toString().trim()
            val msg1: String = interesr_rate.text.toString().trim()
            val msg2: String = loan_tenure.text.toString().trim()


            //check if the EditText have values or not
            /*if((msg == null || msg == "") || (msg1 == null || msg1 == "") || (msg2 == null || msg2 == "")) {
                //Toast.makeText(applicationContext, "Missing Information", Toast.LENGTH_SHORT).show()
                finish();
                startActivity(getIntent());
                loan_emi.text = "Shhhhhh"
            }*/


            val principal :Float = msg.toFloat()
            val rate :Float = msg1.toFloat()
            val time :Float = msg2.toFloat()

            if(principal < 10000 || principal > 2500000)
            {
                Toast.makeText(applicationContext, "Please enter loan amount between 10000 to 2500000", Toast.LENGTH_LONG).show()
                finish();
                startActivity(getIntent());
            }

            if(rate < 5 || rate > 20)
            {
                Toast.makeText(applicationContext, "Please enter interest between 5% to 20%", Toast.LENGTH_LONG).show()
                finish();
                startActivity(getIntent());
            }

            if(time < 1 || time > 7)
            {
                Toast.makeText(applicationContext, "Please enter loan tenures between 1 to 7 years", Toast.LENGTH_LONG).show()
                finish();
                startActivity(getIntent());
            }

            val r = rate / (12 * 100)
            val t = time * 12
            val emi = (principal * r  * Math.pow(1.toDouble() + r.toDouble(), t.toDouble()).toFloat()) /  ((Math.pow(1.toDouble() + r.toDouble(), t.toDouble()).toFloat()) - 1)

            loan_emi.text = Math.ceil(emi.toDouble()).toString()

            val payable_amount = (emi * (12 * time))
            total_payment.text = Math.ceil(payable_amount.toDouble()).toString()

            val total_interest_amount = payable_amount - principal
            total_interest.text = Math.ceil(total_interest_amount.toDouble()).toString()
        }
    }
}