package com.example.homework

import androidx.recyclerview.widget.RecyclerView
import com.example.homework.databinding.EachItemBinding

class LanguageItem(
    private val binding: EachItemBinding,
    private val onItemClick: (LanguageData) -> Unit
) : RecyclerView.ViewHolder(binding.root) {



    fun onBind(language: LanguageData){
        binding.run {
            titleTv.text = language.title
            logoIv.setImageResource(language.logo)

            root.setOnClickListener{
                onItemClick(language)
            }
        }
    }
}