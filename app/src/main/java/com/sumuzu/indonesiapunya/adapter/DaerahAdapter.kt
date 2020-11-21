package com.sumuzu.indonesiapunya.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sumuzu.indonesiapunya.R
import com.sumuzu.indonesiapunya.model.Provinsi
import kotlinx.android.synthetic.main.item_daerah.view.*

class DaerahAdapter(var data: ArrayList<Provinsi>?) : RecyclerView.Adapter<DaerahAdapter.DaerahHolder>() {
    class DaerahHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val nama = itemView.tvPropinsi

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaerahHolder{

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_daerah, parent, false)
        val holder = DaerahHolder(view)

        return holder
    }

    override fun onBindViewHolder(holder: DaerahHolder, position: Int) {
        holder.nama.text = data?.get(position)?.nama
    }

    override fun getItemCount(): Int = data?.size ?:0
}