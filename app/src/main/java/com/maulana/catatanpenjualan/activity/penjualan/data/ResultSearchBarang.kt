package com.maulana.catatanpenjualan.activity.penjualan.data

import com.google.gson.annotations.SerializedName
import com.maulana.catatanpenjualan.model.Barang
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class ResultSearchBarang(

    @field:SerializedName("barang")
    val barang: List<Barang?>? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: Int? = null
)