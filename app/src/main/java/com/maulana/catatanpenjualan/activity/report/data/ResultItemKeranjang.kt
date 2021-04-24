package com.maulana.catatanpenjualan.activity.report.data

import com.google.gson.annotations.SerializedName
import com.maulana.catatanpenjualan.model.Keranjang
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class ResultItemKeranjang(

    @field:SerializedName("keranjang")
    val keranjang: Keranjang? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: Int? = null
)