package com.sumuzu.indonesiapunya.network

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {

    companion object{
        fun getRetrofitBatik() : BatikService{
            val retrofitBatik = Retrofit.Builder()
                .baseUrl("http://batikita.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service : BatikService = retrofitBatik.create<BatikService>(BatikService::class.java)

            return service
        }

        fun getRetrofitMuseum() : MuseumService{
            val retrofitMuseum = Retrofit.Builder()
                .baseUrl("http://jendela.data.kemdikbud.go.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service : MuseumService = retrofitMuseum.create<MuseumService>(MuseumService::class.java)

            return service
        }

        fun getRetrofitDaerah() : DaerahService{
            val retrofitDaerah = Retrofit.Builder()
                .baseUrl("https://dev.farizdotid.com/api/daerahindonesia/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service : DaerahService = retrofitDaerah.create<DaerahService>(DaerahService::class.java)

            return service
        }

        fun getRetrofitCovid() : CovidService{
            val retrofitCovid = Retrofit.Builder()
                .baseUrl("https://indonesia-covid-19.mathdro.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service : CovidService = retrofitCovid.create<CovidService>(CovidService::class.java)

            return service
        }

    }

}