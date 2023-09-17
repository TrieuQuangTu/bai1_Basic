package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val STATE = "Trạng thái"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e(STATE,"onCreate")

        //truyền 1 object sử dụng bundle
        binding.btnTruyenObject.setOnClickListener {
            sentObject()
        }
    }

    private fun sentObject() {

        //lấy giá trị của 2 editText
        val name = binding.editUsername.text.toString()
        val password = binding.editPassword.text.toString()

        //gán vào 1 đối tượng
        val user =User(name,password)

        val intent_object = Intent(this, Main2::class.java)

        //sử dụng bundle để truyền dữ liệu
        val bundle = Bundle()
        bundle.putSerializable("truyenobject",user)
        intent_object.putExtras(bundle)

        startActivity(intent_object)
    }
    override fun onStart() {
        super.onStart()
        Log.e(STATE,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e(STATE,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e(STATE,"onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(STATE,"onDestroy")

    }
}