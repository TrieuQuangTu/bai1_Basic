package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class Fragment1 : Fragment() {


    private lateinit var btn2:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_1,container,false)

        btn2 =view.findViewById(R.id.btn_navigatefm2)
        btn2.setOnClickListener {
            val fm2 = Fragment2()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view_tag,fm2)
                .commit()
        }
        return view


    }


}