package com.example.listadapterexampleproject

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class BaseDiffUtilItemCallback<T> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
    //İki nesnenin aynı Öğeyi temsil edip etmediğine karar vermek için DiffUtil tarafından çağrılır.
    //Örneğin, öğelerinizin benzersiz kimlikleri varsa, bu yöntem kimliklerinin eşitliğini kontrol etmelidir.

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
    //İki öğenin aynı verilere sahip olup olmadığını kontrol etmek istediğinde DiffUtil tarafından çağrılır.
    // DiffUtil, bir öğenin içeriğinin değişip değişmediğini tespit etmek için bu bilgiyi kullanır.
}