package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intent.databinding.ActivityMain2Binding

class Main2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        //c) nhận 1 object sử dụng bundle
        val bundle_nhan: User = intent.getSerializableExtra("truyenobject") as User

        //set dữ liệu đã nhận vào vào 2 EditText
        binding.editNhanUsername.setText(bundle_nhan.name)
        binding.editNhanPassword.setText(bundle_nhan.password)

    }
}