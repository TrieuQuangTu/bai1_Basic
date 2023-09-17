package com.example.customlistview

import android.annotation.SuppressLint
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.customlistview.databinding.ActivityMainBinding
import com.example.customlistview.ui.Adapter.UserAdapter
import com.example.customlistview.ui.Model.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mList:ArrayList<User>
    private lateinit var mAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //b1: thiet lap layoutManager
        binding.recyclerview.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)

        //b2:khoi tao mang ArrayList
        mList = ArrayList()
        mList.add(User("Alex","22","Male"))
        mList.add(User("Jerry","21","Female"))
        mList.add(User("Tom","21","Male"))
        mList.add(User("Jack","22","Male"))

        //b3: ket noi apdater voi recyclerview
        mAdapter = UserAdapter(mList)
        binding.recyclerview.adapter = mAdapter

        //click button floatting Add
        binding.btnAdd.setOnClickListener {
            addItem()
        }
    }

    @SuppressLint("MissingInflatedId")
    private fun addItem() {
        //b1: khoi tao doi tuong AlertDialog.Builder
        val builder = AlertDialog.Builder(this)

        //b2: Goi LayoutInflater.inflater
        val view =layoutInflater.inflate(R.layout.custom_dialog,null)

        //setview
        builder.setView(view)

        val dialog =builder.create()

        //anh xa view button va setOnClick
        view.findViewById<Button>(R.id.btn_dialog_add).setOnClickListener {

            val Name = view.findViewById<EditText>(R.id.edit_dialog_name).text.toString()
            val Age = view.findViewById<EditText>(R.id.edit_dialog_age).text.toString()
            val Sex = view.findViewById<EditText>(R.id.edit_dialog_sex).text.toString()

            //kiem tra dieu kien khi ten, tuoi, gioi tinh bo trong
            if(Name.isEmpty() || Age.isEmpty() || Sex.isEmpty()){
                Toast.makeText(this,"Vui long nhap du thong tin", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            //nguoc lai neu day du thong tin
            else
            {
                mList.add(User("FullName: $Name","Age: $Age","Sex: $Sex"))
                mAdapter.notifyDataSetChanged()
                Toast.makeText(this,"Add Item thanh cong", Toast.LENGTH_SHORT).show()
            }
            //sau khi add xong hop AlertDialog se bien mat
            dialog.dismiss()
        }
        //anh xa view button va setOnClick button cancel
        view.findViewById<Button>(R.id.btn_dialog_cancel).setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()



    }
}