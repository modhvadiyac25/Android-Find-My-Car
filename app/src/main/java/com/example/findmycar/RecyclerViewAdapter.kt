package com.example.findmycar

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    var database: DatabaseReference = FirebaseDatabase.getInstance().getReference("cars")
//    fun retriveData() {
//        itemTitles.clear()
//        itemDetails.clear()
//        var getdata = object : ValueEventListener {
//            override fun onCancelled(error: DatabaseError) {
//
//            }
//
//            override fun onDataChange(snapshot: DataSnapshot) {
//                //var sb = StringBuilder()
//                for (i in snapshot.children) {
//                    itemTitles.add(i.child("").child("brand").getValue().toString() +" "+ i.child("").child("name").getValue().toString() )
//                    itemDetails.add(i.child("").child("price").getValue().toString())
//
//                }
//            }
//        }
//
//        database.addValueEventListener(getdata)
//        database.addListenerForSingleValueEvent(getdata)
//
//    }

        private val itemTitles = arrayOf("Hyundai i20","Hyundai Creta","Hyundai Venue","Kia Seltos","Kia Sonet","Renault Kiger","Maruti Suzuki Baleno","Maruti Suzuki Swift","Tata Safari","Toyota Innova Crysta")
        private val itemDetails = arrayOf("₹6.80 Lakh","₹10 Lakh","₹6.87 Lakh","₹9.90 Lakh","₹6.79 Lakh","₹5.45 Lakh","₹5.88 Lakh","₹5.73 Lakh","₹14.70 Lakh","₹16.27 Lakh")


//    private var itemTitles: ArrayList<String> = ArrayList()
//    private var itemDetails: ArrayList<String> = ArrayList()

    private val itemImages = intArrayOf(
        R.drawable.hyn_i20,
        R.drawable.img_hyn_creta,
        R.drawable.img_hyn_venue,
        R.drawable.img_kia_seltos,
        R.drawable.img_kia_sonet,
        R.drawable.img_ren_kiger,
        R.drawable.img_msz_baleno,
        R.drawable.img_msz_swift,
        R.drawable.img_tata_safari,
        R.drawable.img_toy_invno_crysta
    )


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var textTitle: TextView
        var textDes: TextView

        init {

            itemView.setOnClickListener{
                val position : Int = adapterPosition
                Toast.makeText(it.context,"position = $position ",Toast.LENGTH_LONG).show()
            }

            image = itemView.findViewById(R.id.car_img)
            textTitle = itemView.findViewById(R.id.car_name)
            textDes = itemView.findViewById(R.id.car_price)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_model, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textTitle.text = itemTitles[position]
        holder.textDes.text = itemDetails[position]
        holder.image.setImageResource(itemImages[position])

    }

    var flage = true
    override fun getItemCount(): Int {
//        if(flage){
//            retriveData()
//            flage=false
//        }

        return itemTitles.size
    }

}