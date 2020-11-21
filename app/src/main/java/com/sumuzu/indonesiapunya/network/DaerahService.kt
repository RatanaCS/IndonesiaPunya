package com.sumuzu.indonesiapunya.network

import com.sumuzu.indonesiapunya.model.ResponseDaerahServer
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DaerahService {

    @GET("provinsi")
    fun getDataDaerah() : Call<ResponseDaerahServer>

    @GET("kota?id_provinsi=")
    fun getDataKabupaten(@Query("id_provinsi") id_provinsi : String) : Call<ResponseDaerahServer>


}