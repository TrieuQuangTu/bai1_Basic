package com.example.boundservice

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class TinhToanService: Service() {

    private val binder = TinhToanBinder()

    inner class TinhToanBinder: Binder(){

        fun getService():TinhToanService=this@TinhToanService
    }
    fun tinhToan(numA:Int, numB:Int): Int {
        return numA+numB
    }

    override fun onBind(p0: Intent?): IBinder? {
        return binder
    }
}