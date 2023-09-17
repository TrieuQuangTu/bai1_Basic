package com.example.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class BackgroundService:Service() {

    private lateinit var player: MediaPlayer

    override fun onCreate() {
        super.onCreate()

    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        player=MediaPlayer.create(this,R.raw.nhacchuong)
        player.isLooping=true
        player.start()
        return START_STICKY
    }
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()

        player.stop()
    }
    //khi chay ma bam click ko keu nhac thi vao tep manifest ke khai <service
}