package com.example.homework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.databinding.EachItemBinding


class LanguageAdapter(
    private var mList: List<LanguageData>,
    private val onItemClick: (LanguageData) -> Unit) :
    RecyclerView.Adapter<LanguageItem>() {

    override fun onBindViewHolder(holder: LanguageItem, position: Int) {
        holder.onBind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageItem = LanguageItem(
        EachItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        onItemClick = onItemClick
    )
}