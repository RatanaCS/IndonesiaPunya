package com.sumuzu.indonesiapunya.museum

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.MenuItemCompat
import androidx.appcompat.widget.SearchView
import com.sumuzu.indonesiapunya.R
import com.sumuzu.indonesiapunya.adapter.MuseumAdapter
import com.sumuzu.indonesiapunya.model.Museum
import com.sumuzu.indonesiapunya.model.ResponseMuseumServer
import com.sumuzu.indonesiapunya.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_covid.*
import kotlinx.android.synthetic.main.activity_museum.*
import kotlinx.android.synthetic.main.activity_museum.progress
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class MuseumActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum)

        showAllMuseum()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        val menuItem = menu!!.findItem(R.id.action_search)

        if(menuItem != null){
            val searchView = menuItem.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    if (newText!!.isEmpty()){

                        showAllMuseum()

                        rvMuseum.adapter!!.notifyDataSetChanged()
                    }else{

                        val search = newText.toLowerCase(Locale.getDefault())

                        showFilterMuseum(search)

                        rvMuseum.adapter!!.notifyDataSetChanged()
                    }

                    return true
                }

            })
        }

        return super.onCreateOptionsMenu(menu)

    }

    private fun showFilterMuseum(search: String) {
        //filter
        ConfigNetwork.getRetrofitMuseum().getFilterMuseum("$search").enqueue(object : Callback<ResponseMuseumServer>{
            override fun onResponse(
                call: Call<ResponseMuseumServer>,
                response: Response<ResponseMuseumServer>
            ) {
                Log.d("response server Museum", response.message())

                progress.visibility = View.GONE

                if(response.isSuccessful) {

                    val data: ArrayList<Museum>? = response.body()?.data
                    showData(data)

                }
            }

            override fun onFailure(call: Call<ResponseMuseumServer>, t: Throwable) {
                Log.d("error server Museum", t.message)
                progress.visibility = View.GONE
            }

        })

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return super.onOptionsItemSelected(item)
    }

    private fun showData(data: ArrayList<Museum>?) {
            rvMuseum.adapter = MuseumAdapter(data)
    }

    fun isConnect() : Boolean{
        val connect : ConnectivityManager =getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return connect.activeNetworkInfo != null && connect.activeNetworkInfo.isConnected
    }

    private fun showAllMuseum() {
        //show all museum
        ConfigNetwork.getRetrofitMuseum().getDataMuseum().enqueue(object : Callback<ResponseMuseumServer>{
            override fun onResponse(
                call: Call<ResponseMuseumServer>,
                response: Response<ResponseMuseumServer>
            ) {
                Log.d("response server Museum", response.message())

                progress.visibility = View.GONE

                if(response.isSuccessful) {

                    val data: ArrayList<Museum>? = response.body()?.data
                    showData(data)

                }
            }

            override fun onFailure(call: Call<ResponseMuseumServer>, t: Throwable) {
                Log.d("error server Museum", t.message)

                progress.visibility = View.GONE
            }
        })

    }


}