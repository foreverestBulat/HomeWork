package com.example.homework
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.homework.databinding.FragmentLanguageInfoBinding


class LanguageInfoFragment : Fragment(R.layout.fragment_language_info) {

    private lateinit var fragmentBinding: FragmentLanguageInfoBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentBinding = FragmentLanguageInfoBinding.bind(view)

        val planetName = arguments?.getString(ARG_NAME) ?: "Unknown planet"
        val planetId = arguments?.getInt(ARG_ID) ?: -1
        val planetDescription = arguments?.getString(ARG_DESCRIPTION) ?: "Not found"
        val planetURL = arguments?.getString(ARG_URL)

        fragmentBinding?.run {
            textId.text = String.format("ID: $planetId")
            textName.text = String.format("Name: $planetName")
            textDescription.text = String.format("Description: $planetDescription")
            Glide.with(imageViewLanguage.context)
                .load(planetURL)
                .error(R.drawable.image_not_found)
                .into(imageViewLanguage)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    companion object {

        private const val ARG_NAME = "ARG_NAME"
        private const val ARG_ID = "ARG_ID"
        private const val ARG_URL = "ARG_URL"
        private const val ARG_DESCRIPTION = "ARG_DESCRIPTION"

        fun createBundle(language: Language): Bundle {
            val bundle = Bundle()
            bundle.putInt(ARG_ID, language.id)
            bundle.putString(ARG_NAME, language.name)
            bundle.putString(ARG_URL, language.url)
            bundle.putString(ARG_DESCRIPTION, language.description)
            return bundle
        }

    }

}