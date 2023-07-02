package com.example.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.homework.databinding.FragmentNewsBinding

class NewsFragment : Fragment(R.layout.fragment_news) {

    private var binding: FragmentNewsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNewsBinding.bind(view)

        binding?.run{
            btnToProfile.setOnClickListener {
                findNavController().navigate(R.id.action_newsFragment_to_profileFragment,
                    ProfileFragment.createBudle("News"))
            }
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}