package com.sumuzu.indonesiapunya.daerah

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.sumuzu.indonesiapunya.R
import com.sumuzu.indonesiapunya.adapter.DaerahAdapter
import com.sumuzu.indonesiapunya.model.Provinsi
import com.sumuzu.indonesiapunya.model.ResponseDaerahServer
import com.sumuzu.indonesiapunya.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_batik.*
import kotlinx.android.synthetic.main.activity_daerah.*
import kotlinx.android.synthetic.main.activity_daerah.progress
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DaerahActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daerah)

        if(isConnect()){

            ConfigNetwork.getRetrofitDaerah().getDataDaerah().enqueue(object : Callback<ResponseDaerahServer> {
                override fun onResponse(
                    call: Call<ResponseDaerahServer>,
                    response: Response<ResponseDaerahServer>
                ) {

                    Log.i("response daerah server", response.message())

                    progress.visibility = View.GONE

                    if(response.isSuccessful){
                        val data : ArrayList<Provinsi>? = response.body()?.provinsi

                        showData(data)
                    }

                }

                override fun onFailure(call: Call<ResponseDaerahServer>, t: Throwable) {

                    Log.i("error server", t.message)
                    progress.visibility = View.GONE

                }
            })

        }else{
            progress.visibility = View.GONE
            Toast.makeText(this,"device tidak connect dengan intenet", Toast.LENGTH_SHORT).show()
        }

    }

    private fun showData(data: ArrayList<Provinsi>?) {

        rvDaerahIndonesia.adapter = DaerahAdapter(data)

    }

    fun isConnect() : Boolean{
        val connect : ConnectivityManager =getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return connect.activeNetworkInfo != null && connect.activeNetworkInfo.isConnected
    }


}