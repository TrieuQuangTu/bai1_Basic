package com.example.boundservice

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var mTinhToanService:TinhToanService? =null
    private var mBound:Boolean = false

    private val connection =object:ServiceConnection{
        override fun onServiceConnected(classname: ComponentName?, service: IBinder?) {

            val binder =service as TinhToanService.TinhToanBinder
            mTinhToanService = binder.getService()
            mBound=true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            mTinhToanService=null
            mBound=false
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edt_numA:EditText=findViewById(R.id.edt_a)
        val edt_numB:EditText=findViewById(R.id.edt_b)
        val btn_tinh: Button =findViewById(R.id.btn_tinh)
        val txt_ketqua: TextView =findViewById(R.id.txt_ketqua)

        val intent = Intent(this@MainActivity,TinhToanService::class.java)
        bindService(intent,connection, Context.BIND_AUTO_CREATE)

        btn_tinh.setOnClickListener {
            if(mBound==true)
            {
                var a = edt_numA.text.toString().toInt() //ép kiểu String->Int
                var b = edt_numB.text.toString().toInt() //ép kiểu String->Int

                var result = mTinhToanService?.tinhToan(a,b)
                txt_ketqua.setText("$a + $b = ${result.toString()}")
            }
        }

    }

}