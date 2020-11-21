package com.sumuzu.indonesiapunya

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sumuzu.indonesiapunya.batik.BatikActivity
import com.sumuzu.indonesiapunya.covid.CovidActivity
import com.sumuzu.indonesiapunya.daerah.DaerahActivity
import com.sumuzu.indonesiapunya.museum.MuseumActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ibBatik.setOnClickListener {
            val intent = Intent(this, BatikActivity::class.java)
            startActivity(intent)
        }

        ibMuseum.setOnClickListener {
            val intent = Intent(this, MuseumActivity::class.java)
            startActivity(intent)
        }

        ibDaerah.setOnClickListener {
            val intent = Intent (this, DaerahActivity::class.java)
            startActivity(intent)
        }

        ibCovid.setOnClickListener {
            val intent = Intent (this, CovidActivity::class.java)
            startActivity(intent)
        }

    }


}