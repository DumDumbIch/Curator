package com.dumdumbich.curator.domain.interactor

import android.content.Intent

interface IFeedBack {
    fun sendFeedBack(message: String): Intent
}