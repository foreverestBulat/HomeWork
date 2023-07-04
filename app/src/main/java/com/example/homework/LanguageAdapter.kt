package com.example.homework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.homework.databinding.LanguageItemBinding

class LanguageAdapter(
    private var list: List<Language>,
    private val requestManager: RequestManager,
    private val onItemClick: (Language) -> Unit
) : RecyclerView.Adapter<LanguageItem>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LanguageItem = LanguageItem(
        planetBinding = LanguageItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        requestManager = requestManager,
        onItemClick = onItemClick
    )

    override fun onBindViewHolder(holder: LanguageItem, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() : Int = list.size

}