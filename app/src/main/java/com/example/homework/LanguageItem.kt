package com.example.homework

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.example.homework.databinding.LanguageItemBinding

class LanguageItem(
    private val planetBinding: LanguageItemBinding,
    private val requestManager: RequestManager,
    private val onItemClick: (Language) -> Unit
) : ViewHolder(planetBinding.root) {

    fun onBind(language: Language) {
        planetBinding.run {
            itemName.text = language.name
            requestManager
                .load(language.url)
                .error(R.drawable.image_not_found)
                .into(imageView)
            root.setOnClickListener {
                onItemClick(language)
            }
        }
    }

}