package com.matheus.testelojong.base_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.matheus.testelojong.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}