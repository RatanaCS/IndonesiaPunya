package com.sumuzu.indonesiapunya.batik

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.sumuzu.indonesiapunya.R
import com.sumuzu.indonesiapunya.adapter.BatikAdapter
import com.sumuzu.indonesiapunya.model.Batik
import com.sumuzu.indonesiapunya.model.ResponseBatikServer
import com.sumuzu.indonesiapunya.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_batik.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BatikActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_batik)

        if(isConnect()){
            ConfigNetwork.getRetrofitBatik().getDataBatik().enqueue(object  : Callback<ResponseBatikServer>{
                override fun onResponse(
                    call: Call<ResponseBatikServer>,
                    response: Response<ResponseBatikServer>
                ) {
                    Log.d("response server", response.message())

                    progress.visibility = View.GONE

                    if(response.isSuccessful){

                        val data : ArrayList<Batik>? = response.body()?.hasil

                        showData(data)
                    }

                }

                override fun onFailure(call: Call<ResponseBatikServer>, t: Throwable) {
                    Log.d("error server", t.message)
                    progress.visibility = View.GONE
                }
            })
        }else{
            progress.visibility = View.GONE

            Toast.makeText(this,"device tidak connect dengan intenet",Toast.LENGTH_SHORT).show()
        }



    }

    private fun showData(data: ArrayList<Batik>?) {

        rvBatik.adapter = BatikAdapter(data)

    }

    fun isConnect() : Boolean{
        val connect : ConnectivityManager =getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return connect.activeNetworkInfo != null && connect.activeNetworkInfo.isConnected
    }
}