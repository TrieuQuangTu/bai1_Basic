package com.example.part1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class BroadcastAirPlane :BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {

        val isAirPlaneMode =intent!!.getBooleanExtra("state",false)

        if(isAirPlaneMode){
            Toast.makeText(context,"Air Plane Mode is On",Toast.LENGTH_SHORT).show()
        }
        else
            Toast.makeText(context,"Air Plane Mode is Off",Toast.LENGTH_SHORT).show()

    }

}