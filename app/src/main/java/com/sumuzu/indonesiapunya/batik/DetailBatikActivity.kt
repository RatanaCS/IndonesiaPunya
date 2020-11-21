package com.sumuzu.indonesiapunya.batik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.sumuzu.indonesiapunya.R
import kotlinx.android.synthetic.main.activity_detail_batik.*

class DetailBatikActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_batik)

        val nama = intent.getStringExtra("nama")
        val gambar = intent.getStringExtra("gambar")
        val daerah = intent.getStringExtra("daerah")
        val makna = intent.getStringExtra("makna")
        val hRendah = intent.getStringExtra("hRendah")
        val hTinggi = intent.getStringExtra("hTinggi")

        tvNamaBatikDetail.text = nama
        tvDaerahBatikdetail.text = daerah
        tvMaknaBatikdetail.text = makna
        tvHargaRendah.text = "Rp. $hRendah,-"
        tvHargaTinggi.text = "Rp. $hTinggi,-"

        Glide.with(this).load(gambar).into(ivBatikDetail)


    }
}