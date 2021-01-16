package com.example.listadapterexampleproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.listadapterexampleproject.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userListRv: RecyclerView
    private lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initViews()
        initAdapter()
        updateUserList()
    }

    private fun updateUserList() {
        lifecycleScope.launch {
            delay(4000)
            userAdapter.submitList(getChangedChangedList())
        }
    }


    private fun getUserList() = mutableListOf<UserModel>().apply {
        repeat(15) {
            add(UserModel(it, "Oğuz Şahin", "Android Developer"))
        }
    }

    private fun getChangedChangedList() = mutableListOf<UserModel>().apply {
        repeat(15) {
            if (it % 2 == 0) {
                add(UserModel(it, "Oğuz Şahin", "Android Developer"))
            } else {
                add(UserModel(it, "Hasan Güngör", "IOS Developer"))
            }
        }
    }

    private fun initViews() {
        with(binding) {
            userListRv = mainActivityUserListRv
        }
    }

    private fun initAdapter() {
        userAdapter = UserAdapter()
        userListRv.adapter = userAdapter
        userAdapter.submitList(getUserList())
    }
}