package com.example.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.homework.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private var fragmentBinding: FragmentMainBinding? = null
    private var adapter: LanguageAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentBinding = FragmentMainBinding.bind(view)

        initAdapter()
    }
    private fun initAdapter() {
        adapter = LanguageAdapter(
            LanguagesRepository.list,
            Glide.with(this) )
        {
            findNavController().navigate(
                R.id.action_mainFragment2_to_languageInfoFragment,
                LanguageInfoFragment.createBundle(language = it))
        }
        fragmentBinding?.languagesRv?.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentBinding = null
    }

}