package com.example.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.homework.databinding.FragmentMusicBinding

class MusicFragment : Fragment(R.layout.fragment_music) {

    private var binding: FragmentMusicBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMusicBinding.bind(view)

        binding?.run{
            btnToProfile.setOnClickListener {
                findNavController().navigate(R.id.action_musicFragment_to_profileFragment,
                    ProfileFragment.createBudle("Music"))
            }
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}