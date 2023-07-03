package com.example.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.homework.databinding.FragmentFavBinding

class FavFragment : Fragment(R.layout.fragment_fav) {

    private var binding: FragmentFavBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFavBinding.bind(view)

        binding?.run{
            btnToProfile.setOnClickListener {
                findNavController().navigate(R.id.action_favFragment_to_profileFragment,
                    ProfileFragment.createBudle(resources.getString(R.string.createBudleName)))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}