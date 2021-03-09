package com.example.findmycar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_emicalculator.*

class EMICalculator : AppCompatActivity() {

//    fun power(base:Double, power: Double) : Double
//    {
//        var result: Double = 1.0
//
//        var power1 = power.toInt()
//
//        for(i in 1..power1)
//            result *= base
//        return  result
//    }
//
//    private var principle_amountView: TextView? = null
//    private var principle_amount_seekbaarView: SeekBar? = null
//
//    private var interest_amountView: TextView? = null
//    private var innterest_amount_seekbarView: SeekBar? = null
//
//    private var loan_tenureView: TextView? = null
//    private var loan_tenure_seekbarrView: SeekBar? = null
//
//    private var emiView: TextView? = null;
//    private var total_interestView: TextView? = null;
//    private var pyable_amountView: TextView? = null;
//
//    var MIN = 10000
//    var MAX = 2000000
//    var STEP = 10000
//
//    var MIN1 = 500
//    var MAX1 = 2000
//    var STEP1 = 25
//
//    var MIN2 = 1
//    var MAX2 = 8
//    var STEP2 = 1
//
//    var progress_custom: Float = 0.0f
//    var progress_custom1: Float = 0.0f
//    var progress_custom2: Float = 0.0f
//
//    var p: Float = 0.0f
//    var r: Float= 0.0f
//    var n: Float= 0.0f
//    var emi_amount: Float = 0.0f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emicalculator)

//        principle_amountView = this.principle_amount
//        principle_amount_seekbaarView = this.principle_amount_seekbaar
//        principle_amount_seekbaarView!!.max = (MAX - MIN) / STEP
//        principle_amount_seekbaarView!!.setOnSeekBarChangeListener(this)
//        principle_amountView!!.text = "10000"
//
//        interest_amountView = this.interest_amouunt
//        innterest_amount_seekbarView = this.innterest_amount_seekbar
//        innterest_amount_seekbarView!!.max = (MAX1 - MIN1) / STEP1
//        innterest_amount_seekbarView!!.setOnSeekBarChangeListener(this)
//        interest_amountView!!.text = "5"
//
//        loan_tenureView = this.loan_tenure
//        loan_tenure_seekbarrView = this.loan_tenure_seekbar
//        loan_tenure_seekbarrView!!.max = (MAX2 - MIN2) / STEP2
//        loan_tenure_seekbarrView!!.setOnSeekBarChangeListener(this)
//        loan_tenureView!!.text = "1"
//
//        emiView = this.emi;
//        total_interestView = this.total_interest;
//        pyable_amountView = this.pyable_amount;
//
//        emiView!!.text = "856"
//        total_interestView!!.text = "273"
//        pyable_amountView!!.text = "10273"


  //  }

//    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
//
//        var seekBar1: SeekBar = findViewById(R.id.principle_amount_seekbaar);
//        var seekBar2: SeekBar = findViewById(R.id.innterest_amount_seekbar);
//        var seekBar3: SeekBar = findViewById(R.id.loan_tenure_seekbar);
//
//        if(seekBar.equals(seekBar1))
//        {
//            Toast.makeText(this,principle_amountView!!.text,Toast.LENGTH_LONG).show()
//            progress_custom = (MIN + ( progress * STEP )).toFloat()
//            principle_amountView!!.text = (progress_custom.toFloat()).toString()
//
//        }
//
//        else if(seekBar.equals(seekBar2))
//        {
//            progress_custom1 = (MIN1 + (progress * STEP1)).toFloat()
//            r = (progress_custom1/100.0).toFloat()
//            interest_amountView!!.text = ((progress_custom1/100.0f).toFloat()).toString()
//        }
//
//        else if(seekBar.equals(seekBar3))
//        {
//            progress_custom2 = (MIN2 + ( progress * STEP2 )).toFloat()
//            n = progress_custom2.toFloat()
//            loan_tenureView!!.text = progress_custom2.toString()
//        }
//
//        this.r /= (12 * 100)
//        this.n *= 12
//
//
//        var a:Float = 1 + r
//        var b:Float = n
//        var c:Int = b.toInt()
//        var result:Float = 1.0f
//
//        while (c != 0)
//        {
//            result *= a
//            c--
//        }
//
//
//        var d:Float = 1 + r
//        var e:Float = n
//        var f:Int = e.toInt()
//        var result1:Float = 1.0f
//
//        while (f != 0) {
//            result1 *= d
//            f--
//        }
//
//
//        var temp:Float = result / (result1 - 1)
//
//        emi_amount = progress_custom.toFloat() * r * temp
//
//
//
//        emiView!!.text = emi_amount.toString()
//


        //var payable_amount = (emi_amount * (12 * n))
        //var interest = payable_amount - p

        //total_interestView!!.text =  interest.toString()
        //pyable_amountView!!.text = payable_amount.toString()
    }

//    override fun onStartTrackingTouch(seekBar: SeekBar?) {
//        var a = ""
//    }
//
//    override fun onStopTrackingTouch(seekBar: SeekBar?) {
//        var b = ""
//    }


}
