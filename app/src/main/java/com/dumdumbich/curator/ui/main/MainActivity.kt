package com.dumdumbich.curator.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import com.dumdumbich.curator.R
import com.dumdumbich.curator.databinding.ActivityMainBinding
import com.dumdumbich.curator.ui.App
import com.dumdumbich.curator.ui.navigator.AndroidScreens
import com.dumdumbich.curator.ui.navigator.IBackClickListener
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), IMainView {

    private val navigator = AppNavigator(this, R.id.container)

    private lateinit var ui: ActivityMainBinding
    private val presenter by moxyPresenter {
        MainPresenter(App.instance.router, AndroidScreens())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(ui.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is IBackClickListener && it.isBackPressed()) {
                return
            }
        }
        presenter.backClicked()
    }

}