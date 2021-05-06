package com.dumdumbich.curator.driver

import android.content.Intent
import com.dumdumbich.curator.R
import com.dumdumbich.curator.domain.interactor.IFeedBack

class EMail : IFeedBack {

    override fun sendFeedBack(message: String) =
        Intent(Intent.ACTION_SEND).apply {
            type = "plain/text"
            putExtra(Intent.EXTRA_EMAIL, R.string.developer_email)
            putExtra(Intent.EXTRA_SUBJECT, R.string.email_subject_feedback)
            putExtra(Intent.EXTRA_TEXT, message)
        }

}