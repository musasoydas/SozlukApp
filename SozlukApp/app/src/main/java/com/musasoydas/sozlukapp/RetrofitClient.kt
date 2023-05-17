package com.musasoydas.sozlukapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    //sınıfa doğrudan erişim için companion object kullanıyoruz
    companion object {

        fun getClient(baseurl: String): Retrofit {

            return Retrofit. Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}