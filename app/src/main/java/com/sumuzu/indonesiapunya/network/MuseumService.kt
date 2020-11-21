package com.sumuzu.indonesiapunya.network

import com.sumuzu.indonesiapunya.model.ResponseMuseumServer
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MuseumService {

    @GET("api/index.php/CcariMuseum/searchGET?nama=museum")
    fun getDataMuseum(): Call<ResponseMuseumServer>

    @GET("api/index.php/CcariMuseum/searchGET?nama=")
    fun getFilterMuseum(@Query("nama") nama : String) : Call<ResponseMuseumServer>
}