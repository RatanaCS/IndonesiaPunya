package com.sumuzu.indonesiapunya.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sumuzu.indonesiapunya.R
import com.sumuzu.indonesiapunya.model.Covid
import kotlinx.android.synthetic.main.item_covid.view.*

class CovidAdapter(var data: ArrayList<Covid>?) : RecyclerView.Adapter<CovidAdapter.CovidHolder>() {
    class CovidHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val prov = itemView.tvProvinsi
        val positif = itemView.tvPositif
        val sembuh = itemView.tvSembuh
        val meninggal = itemView.tvMeninggal

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_covid, parent, false)
        val holder = CovidHolder(view)

        return holder
    }

    override fun onBindViewHolder(holder: CovidHolder, position: Int) {
        holder.prov.text = data?.get(position)?.provinsi.toString().toUpperCase()
        holder.positif.text = data?.get(position)?.kasusPosi.toString() + " Orang"
        holder.sembuh.text = data?.get(position)?.kasusSemb.toString() + " Orang"
        holder.meninggal.text = data?.get(position)?.kasusMeni.toString() + " Orang"
    }

    override fun getItemCount(): Int = data?.size ?:0
}