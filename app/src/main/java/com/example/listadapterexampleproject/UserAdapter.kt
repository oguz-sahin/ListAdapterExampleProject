package com.example.listadapterexampleproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listadapterexampleproject.databinding.ItemUserListBinding


class UserAdapter :
    ListAdapter<UserModel, UserAdapter.ViewHolder>(BaseDiffUtilItemCallback<UserModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemUserListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemUserListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindTo(user: UserModel) {
            with(binding) {
                itemUserListUserNameTv.text = user.name
                itemUserListUserJobTv.text = user.job
            }

        }
    }
}