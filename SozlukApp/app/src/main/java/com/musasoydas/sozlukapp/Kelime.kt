package com.musasoydas.sozlukapp


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Kelime(
    @SerializedName("kelimeler")
    @Expose
    val kelimeler: List<Kelimeler>,
    @SerializedName("success")
    @Expose
    val success: Int?
)