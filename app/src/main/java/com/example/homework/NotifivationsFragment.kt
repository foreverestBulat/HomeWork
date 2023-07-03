package com.example.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.homework.databinding.FragmentNotifivationsBinding

class NorificationsFragment : Fragment(R.layout.fragment_notifivations) {
    private var binding: FragmentNotifivationsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNotifivationsBinding.bind(view)

        binding?.run{
            btnToProfile.setOnClickListener {
                findNavController().navigate(R.id.action_norificationsFragment_to_profileFragment,
                    ProfileFragment.createBudle("Notifications"))
            }
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}