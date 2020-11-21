package com.sumuzu.indonesiapunya.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sumuzu.indonesiapunya.R
import com.sumuzu.indonesiapunya.batik.DetailBatikActivity
import com.sumuzu.indonesiapunya.model.Batik
import kotlinx.android.synthetic.main.item_batik.view.*

class BatikAdapter(var data: ArrayList<Batik>?) :RecyclerView.Adapter<BatikAdapter.BatikHolder>(){
    class BatikHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val img = itemView.ivBatik
        val nama = itemView.tvNamaBatik
        val daerah = itemView.tvDaerahBatik

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatikHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_batik, parent, false)
        val holder = BatikHolder(view)

        return holder
    }

    override fun onBindViewHolder(holder: BatikHolder, position: Int) {
        holder.nama.text = data?.get(position)?.nama_batik
        holder.daerah.text = data?.get(position)?.daerah_batik

        Glide.with(holder.itemView.context).load(data?.get(position)?.link_batik).into(holder.img)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailBatikActivity::class.java)
            intent.putExtra("nama", data?.get(position)?.nama_batik)
            intent.putExtra("gambar", data?.get(position)?.link_batik)
            intent.putExtra("daerah", data?.get(position)?.daerah_batik)
            intent.putExtra("makna", data?.get(position)?.makna_batik)
            intent.putExtra("hRendah", data?.get(position)?.harga_rendah.toString())
            intent.putExtra("hTinggi", data?.get(position)?.harga_tinggi.toString() )

            holder.itemView.context.startActivity(intent)


        }

    }

    override fun getItemCount(): Int = data?.size ?:0


}