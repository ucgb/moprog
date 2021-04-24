package com.maulana.catatanpenjualan.activity.login

import com.maulana.catatanpenjualan.model.User

interface LoginView {
    fun onSuccessLogin(user: User?)
    fun onErrorLogin(msg: String?)
}