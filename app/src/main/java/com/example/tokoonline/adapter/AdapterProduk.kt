package com.example.tokoonline.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.tokoonline.MainActivity
import com.example.tokoonline.R
import com.example.tokoonline.activity.DetailProdukActivity
import com.example.tokoonline.activity.LoginActivity
import com.example.tokoonline.helper.Helper
import com.example.tokoonline.model.Produk
import com.example.tokoonline.util.Config
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class AdapterProduk(var activity: Activity, var data:ArrayList<Produk>):RecyclerView.Adapter<AdapterProduk.Holder>() {
    class Holder(view: View):RecyclerView.ViewHolder(view){
        val tvNama = view.findViewById<TextView>(R.id.tv_nama)
        val tvHarga = view.findViewById<TextView>(R.id.tv_harga)
        val imgProduk = view.findViewById<ImageView>(R.id.img_produk)
        val layout = view.findViewById<CardView>(R.id.layout_utama)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_produk, parent, false)
        return Holder(view)
    }


    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.tvNama.text = data[position].name
        holder.tvHarga.text = Helper().gantiRupiah(data[position].harga)
        val image = Config.productUrl + data[position].image
        Picasso.get()
            .load(image)
            .placeholder(R.drawable.hp_pavilion_15_cx0056wm)
            .error(R.drawable.hp_pavilion_15_cx0056wm)
            .into(holder.imgProduk)

        holder.layout.setOnClickListener {
            val intentvity = Intent(activity, DetailProdukActivity::class.java)

            val str = Gson().toJson(data[position], Produk::class.java)
            intentvity.putExtra("extra", str)

            activity.startActivity(intentvity)
        }
    }
}






















