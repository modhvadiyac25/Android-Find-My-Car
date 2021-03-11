package com.example.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import androidx.annotation.RequiresApi
import com.example.findmycar.R
import kotlinx.android.synthetic.main.activity_car_details.*

class CarDetails : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_details)

        expandBtn.setOnClickListener {
            if(expandableLayout.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                expandableLayout.visibility = View.VISIBLE
                expandBtn.text = "COLLAPSE"
            } else {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                expandableLayout.visibility = View.GONE
                expandBtn.text = "EXPAND"
            }
        }

        expandBtn1.setOnClickListener {
            if(expandableLayout1.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                expandableLayout1.visibility = View.VISIBLE
                expandBtn1.text = "COLLAPSE"
            } else {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                expandableLayout1.visibility = View.GONE
                expandBtn1.text = "EXPAND"
            }
        }

        expandBtn2.setOnClickListener {
            if(expandableLayout2.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                expandableLayout2.visibility = View.VISIBLE
                expandBtn2.text = "COLLAPSE"
            } else {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                expandableLayout2.visibility = View.GONE
                expandBtn2.text = "EXPAND"
            }
        }

        expandBtn3.setOnClickListener {
            if(expandableLayout3.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                expandableLayout3.visibility = View.VISIBLE
                expandBtn3.text = "COLLAPSE"
            } else {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                expandableLayout3.visibility = View.GONE
                expandBtn3.text = "EXPAND"
            }
        }

        expandBtn4.setOnClickListener {
            if(expandableLayout4.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                expandableLayout4.visibility = View.VISIBLE
                expandBtn4.text = "COLLAPSE"
            } else {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                expandableLayout4.visibility = View.GONE
                expandBtn4.text = "EXPAND"
            }
        }

        expandBtn5.setOnClickListener {
            if(expandableLayout5.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                expandableLayout5.visibility = View.VISIBLE
                expandBtn5.text = "COLLAPSE"
            } else {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                expandableLayout5.visibility = View.GONE
                expandBtn5.text = "EXPAND"
            }
        }

        expandBtn6.setOnClickListener {
            if(expandableLayout6.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                expandableLayout6.visibility = View.VISIBLE
                expandBtn6.text = "COLLAPSE"
            } else {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                expandableLayout6.visibility = View.GONE
                expandBtn6.text = "EXPAND"
            }
        }

        expandBtn7.setOnClickListener {
            if(expandableLayout7.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                expandableLayout7.visibility = View.VISIBLE
                expandBtn7.text = "COLLAPSE"
            } else {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                expandableLayout7.visibility = View.GONE
                expandBtn7.text = "EXPAND"
            }
        }
    }
}