package com.example.customlistview.ui.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.customlistview.databinding.RowItemUserBinding
import com.example.customlistview.ui.Model.User

class UserAdapter(private var list:ArrayList<User>):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    inner class UserViewHolder(val binding: RowItemUserBinding):RecyclerView.ViewHolder(binding.root){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {

        var view = RowItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {

        var currentItem = list[position]
        holder.binding.tvName.text = currentItem.name
        holder.binding.tvAge.text = currentItem.age
        holder.binding.tvSex.text = currentItem.sex
    }

    override fun getItemCount(): Int {
        return list.size
    }
}