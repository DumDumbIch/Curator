package com.dumdumbich.curator.ui.pages.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dumdumbich.curator.R
import com.dumdumbich.curator.databinding.FragmentAboutBinding
import com.dumdumbich.curator.ui.App
import com.dumdumbich.curator.ui.navigator.IBackClickListener
import com.dumdumbich.curator.utils.debug.DEBUG_AboutFragment
import com.dumdumbich.curator.utils.debug.IDebug
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class AboutFragment : MvpAppCompatFragment(), IAboutView, IBackClickListener, IDebug {

    companion object {
        fun newInstance() = AboutFragment()
    }

    private val presenter by moxyPresenter {
        AboutPresenter().apply {
            App.instance.initAboutSubcomponent().inject(this)
        }
    }

    private var ui: FragmentAboutBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentAboutBinding.inflate(inflater, container, false).also {
            ui = it
        }.root

    override fun init() {
        ui?.btnAddLike?.setOnClickListener {
            debugMessage(DEBUG_AboutFragment, "AboutFragment(): init() btnAddLike.setOnClickListener()")
            presenter.closeScreen()
            presenter.sendFeedBack(getString(R.string.feedback_template_like))
        }
        ui?.btnDisLike?.setOnClickListener {
            debugMessage(DEBUG_AboutFragment, "AboutFragment(): init() btnDisLike.setOnClickListener()")
            presenter.closeScreen()
            presenter.sendFeedBack(getString(R.string.feedback_template_dislike))
        }
    }

    override fun isBackPressed(): Boolean = presenter.closeScreen()

    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }

}