package com.example.findmycar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.example.findmycar.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_car_details.*

class CarDetails : AppCompatActivity() {

    var database: DatabaseReference = FirebaseDatabase.getInstance().getReference("cars")
    var uid = FirebaseAuth.getInstance().currentUser?.uid

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_details)

        // show details
        val car_id = "1" //intent.getStringExtra("car_id").toString()

        var getdata = object : ValueEventListener {

            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                //var sb = StringBuilder()
                for (i in snapshot.children) {
                    if (car_id.equals(i.child("cid").getValue())) {
                        var Brand = i.child("Brand").getValue().toString()
                        var Could_Be_Better = i.child("Could_Be_Better").getValue().toString()
                        var Description = i.child("Description").getValue().toString()
                        var Emission_Standard = i.child("Emission_Standard").getValue().toString()
                        var Engine = i.child("Engine").getValue().toString()
                        var Engine_Type = i.child("Engine_Type").getValue().toString()
                        var Fuel_Tank_Capacity = i.child("Fuel_Tank_Capacity").getValue().toString()
                        var Fuel_Type = i.child("Fuel_Type").getValue().toString()
                        var Good_Things = i.child("Good_Things").getValue().toString()
                        var Height = i.child("Height").getValue().toString()
                        var ImageUrl = i.child("ImageUrl").getValue().toString()
                        var Length = i.child("Length").getValue().toString()
                        var Max_Power = i.child("Max_Power").getValue().toString()
                        var Max_Torque = i.child("Max_Torque").getValue().toString()
                        var Mileage = i.child("Mileage").getValue().toString()
                        var Model = i.child("Model").getValue().toString()
                        var Name = i.child("Name").getValue().toString()
                        var Price= i.child("Price").getValue().toString()
                        var Seating_Capacity= i.child("Seating_Capacity").getValue().toString()
                        var Transmission_Type= i.child("Transmission_Type").getValue().toString()
                        var Width= i.child("Width").getValue().toString()
                        var GC = i.child("Ground_Clearance").getValue().toString()
                        var DriveTrain = i.child("DriveTrain").getValue().toString()
                        var Bootspace = i.child("Bootspace").getValue().toString()
                        var Verdict = i.child("Verdict").getValue().toString()
                        var color1 = i.child("colors").child("c1").getValue().toString()
                        var color2 = i.child("colors").child("c2").getValue().toString()
                        var color3 = i.child("colors").child("c3").getValue().toString()
                        var color4 = i.child("colors").child("c4").getValue().toString()
                        var color5 = i.child("colors").child("c5").getValue().toString()


                        //load car image from the firebase
                        var imageref = FirebaseStorage.getInstance().reference.child("cars/" + car_id + ".png" )
                        imageref.downloadUrl.addOnSuccessListener { Uri ->

                            val imageURL = Uri.toString()
                            var IV = findViewById<ImageView>(R.id.car_img1)
                            Glide.with(this@CarDetails)
                                .load(imageURL)
                                .into(IV)
                        }


                        //loaddata to load json data into activity
                        car_name.text = Brand +" "+ Name
                        car_price.text = Price

                        length.text = Length
                        height.text = Height
                        width.text = Width
                        gc.text = GC

                        engine.text = Engine
                        fuel_type.text = Fuel_Type
                        mp.text = Max_Power
                        mt.text = Max_Torque
                        mileage.text = Mileage
                        dt.text = DriveTrain
                        transmission.text = Transmission_Type
                        es.text = Emission_Standard

                        //Capacity
                        sc.text = Seating_Capacity
                        bootspace.text = Bootspace
                        ftc.text = Fuel_Tank_Capacity

                        //Colors
                        c1.text = color1
                        c2.text = color2
                        c3.text = color3
                        c4.text = color4
                        c5.text = color5

                        //good things
                        good_things.text = Good_Things

                        //could be better
                        could_be_better.text = Could_Be_Better

                        //verdict
                        verdict.text = Verdict
                    }
                }
            }
        }
        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)

        //expantion buttons
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