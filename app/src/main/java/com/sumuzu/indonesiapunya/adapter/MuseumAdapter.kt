package com.sumuzu.indonesiapunya.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sumuzu.indonesiapunya.R
import com.sumuzu.indonesiapunya.model.Museum
import kotlinx.android.synthetic.main.item_museum.view.*

class MuseumAdapter(var data: ArrayList<Museum>?) : RecyclerView.Adapter<MuseumAdapter.MuseumHolder>() {
    class MuseumHolder(itemView:View) :RecyclerView.ViewHolder(itemView) {

        val nama = itemView.tvNamaMuseum
        val tahun = itemView.tvTahunBerdiri
        val alamat = itemView.tvAlamatMuseum

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MuseumHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_museum, parent, false)
        val holder = MuseumHolder(view)

        return holder
    }

    override fun onBindViewHolder(holder: MuseumHolder, position: Int) {
        holder.nama.text = data?.get(position)?.nama
        holder.alamat.text = data?.get(position)?.alamat_jalan
        holder.tahun.text = data?.get(position)?.tahun_berdiri


    }

    override fun getItemCount(): Int = data?.size ?:0
}