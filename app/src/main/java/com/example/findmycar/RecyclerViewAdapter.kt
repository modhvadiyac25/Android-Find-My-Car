package com.example.findmycar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

        private val itemTitles = arrayOf("Hyundai i20","Hyundai Creta","Hyundai Venue","Kia Seltos","Kia Sonet","Renault Kiger","Maruti Suzuki Baleno","Maruti Suzuki Swift","Tata Safari","Toyota Innova Crysta")
        private val itemDetails = arrayOf("₹6.80 Lakh","₹10 Lakh","₹6.87 Lakh","₹9.90 Lakh","₹6.79 Lakh","₹5.45 Lakh","₹5.88 Lakh","₹5.73 Lakh","₹14.70 Lakh","₹16.27 Lakh")
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


    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image : ImageView
        var textTitle : TextView
        var textDes : TextView

        init {
            image = itemView.findViewById(R.id.img_hyn_i20)
            textTitle = itemView.findViewById(R.id.car_name)
            textDes = itemView.findViewById(R.id.car_price)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_model,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textTitle.text = itemTitles [position]
        holder.textDes.text = itemDetails [position]
        holder.image.setImageResource(itemImages [position])
    }

    override fun getItemCount(): Int {
        return itemTitles.size
    }

}