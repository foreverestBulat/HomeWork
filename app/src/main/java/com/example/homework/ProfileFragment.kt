package com.example.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.google.android.material.snackbar.Snackbar

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = arguments?.getString(TEXT).orEmpty()
        if(text.isNotEmpty()){
            Snackbar.make(view, text, Snackbar.LENGTH_LONG).show()
        }
    }

    companion object{
        private const val TEXT = "all is good"
        fun createBudle(text:String): Bundle{
            val bundle = Bundle()
            bundle.putString(
                TEXT,
                text
            )
            return bundle
        }
    }
}