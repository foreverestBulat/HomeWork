package com.example.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.homework.databinding.FragmentPlacesBinding

class PlacesFragment : Fragment(R.layout.fragment_places) {
    private var binding: FragmentPlacesBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPlacesBinding.bind(view)

        binding?.run{
            btnToProfile.setOnClickListener {
                findNavController().navigate(R.id.action_placesFragment_to_profileFragment,
                    ProfileFragment.createBudle("Places"))
            }
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}