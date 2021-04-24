package com.maulana.catatanpenjualan.activity.penjualan.data

import com.google.gson.annotations.SerializedName
import com.maulana.catatanpenjualan.model.Keranjang
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class ResultKeranjang(

    @field:SerializedName("keranjang")
    val keranjang: List<Keranjang?>? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: Int? = null
)