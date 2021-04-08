package com.dumdumbich.curator.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.dumdumbich.curator.R
import com.dumdumbich.curator.databinding.ActivityMainBinding
import com.dumdumbich.curator.ui.App
import com.dumdumbich.curator.ui.LOG_D_TAG
import com.dumdumbich.curator.ui.navigator.IBackClickListener
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), IMainView {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator = AppNavigator(this, R.id.container)

    private lateinit var ui: ActivityMainBinding
    private val presenter by moxyPresenter {
        MainPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(LOG_D_TAG, "MainActivity(): onCreate()")
        super.onCreate(savedInstanceState)
        App.instance.appComponent.inject(this)
        ui = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(ui.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
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