package com.dumdumbich.curator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.dumdumbich.curator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var ui: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(ui.root)
    }
}