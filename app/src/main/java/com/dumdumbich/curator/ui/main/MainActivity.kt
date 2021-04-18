package com.dumdumbich.curator.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import com.dumdumbich.curator.R
import com.dumdumbich.curator.databinding.ActivityMainBinding
import com.dumdumbich.curator.ui.App
import com.dumdumbich.curator.ui.navigator.IBackClickListener
import com.dumdumbich.curator.utils.debug.DEBUG_MainActivity
import com.dumdumbich.curator.utils.debug.IDebug
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), IMainView, IDebug {

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
        debugMessage(DEBUG_MainActivity, "MainActivity(): onCreate()")
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var result = true
        when (item.itemId) {
            R.id.mi_main_screen -> { presenter.toHomePage()}
            R.id.mi_database -> {}
            R.id.mi_settings -> {}
            R.id.mi_about -> { presenter.toAboutPage() }
            else -> result = false
        }
        return result
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is IBackClickListener && it.isBackPressed()) {
                return
            }
        }
        presenter.closeApplication()
    }

}