package com.example.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.service.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //click vao Start Background service
        binding.btnStartBackground.setOnClickListener {
            startService(Intent(this@MainActivity,BackgroundService::class.java))
        }

        //click stop background
        binding.btnStopBackground.setOnClickListener {
            stopService(Intent(this@MainActivity,BackgroundService::class.java))
        }
    }
}