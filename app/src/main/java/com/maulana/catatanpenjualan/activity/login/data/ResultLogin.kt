package com.maulana.catatanpenjualan.activity.login.data

import com.google.gson.annotations.SerializedName
import com.maulana.catatanpenjualan.model.User
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class ResultLogin(

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("user")
    val user: User? = null,

    @field:SerializedName("status")
    val status: Int? = null
)