package com.musasoydas.sozlukapp

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface KelimerDAO {

    @POST("sozluk/kelime_ara.php")
    @FormUrlEncoded
    fun kelimeAra(
        @Field("ingilizce") ingilizce: String): Call<Kelime>

    @GET("sozluk/tum_kelimeler.php")
    fun tumKelimeler(): Call<Kelime>
}