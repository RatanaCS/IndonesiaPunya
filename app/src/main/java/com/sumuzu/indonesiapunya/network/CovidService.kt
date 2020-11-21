package com.sumuzu.indonesiapunya.network

import com.sumuzu.indonesiapunya.model.ResponseCovidServer
import retrofit2.Call
import retrofit2.http.GET

interface CovidService {

    @GET("api/provinsi/")
    fun getDataCovid(): Call<ResponseCovidServer>
}