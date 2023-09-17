package com.example.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.part1.BroadcastAirPlane

class MainActivity : AppCompatActivity() {

    val br =BroadcastAirPlane()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var filter =IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(br,filter)
    }

    override fun onDestroy() {
        super.onDestroy()

        unregisterReceiver(br)
    }
}