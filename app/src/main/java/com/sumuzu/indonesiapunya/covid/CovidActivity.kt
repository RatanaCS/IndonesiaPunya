package com.sumuzu.indonesiapunya.covid

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.sumuzu.indonesiapunya.R
import com.sumuzu.indonesiapunya.adapter.CovidAdapter
import com.sumuzu.indonesiapunya.model.Covid
import com.sumuzu.indonesiapunya.model.ResponseCovidServer
import com.sumuzu.indonesiapunya.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_covid.*
import kotlinx.android.synthetic.main.activity_covid.progress
import kotlinx.android.synthetic.main.activity_daerah.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CovidActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid)

        if(isConnect()) {

            ConfigNetwork.getRetrofitCovid().getDataCovid()
                .enqueue(object : Callback<ResponseCovidServer> {
                    override fun onResponse(
                        call: Call<ResponseCovidServer>,
                        response: Response<ResponseCovidServer>
                    ) {
                        Log.d("response Covid server", response.message())

                        progress.visibility = View.GONE

                        if (response.isSuccessful) {
                            val data: ArrayList<Covid>? = response.body()?.data

                            showData(data)

                        }
                    }

                    override fun onFailure(call: Call<ResponseCovidServer>, t: Throwable) {
                        Log.d("error Covid server", t.message)
                        progress.visibility = View.GONE
                    }

                })

        }else{
            progress.visibility = View.GONE
            Toast.makeText(this,"device tidak connect dengan intenet", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showData(data: ArrayList<Covid>?) {
        rvCovid.adapter = CovidAdapter(data)
    }

    fun isConnect() : Boolean{
        val connect : ConnectivityManager =getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return connect.activeNetworkInfo != null && connect.activeNetworkInfo.isConnected
    }
}