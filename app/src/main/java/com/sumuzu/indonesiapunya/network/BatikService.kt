package com.sumuzu.indonesiapunya.network

import com.sumuzu.indonesiapunya.model.ResponseBatikServer
import retrofit2.Call
import retrofit2.http.GET

interface BatikService {

    @GET("index.php/batik/all")
    fun getDataBatik():Call<ResponseBatikServer>

}

