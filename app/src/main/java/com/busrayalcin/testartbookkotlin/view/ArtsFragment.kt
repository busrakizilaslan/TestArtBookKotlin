package com.busrayalcin.testartbookkotlin.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.busrayalcin.testartbookkotlin.R
import com.busrayalcin.testartbookkotlin.databinding.FragmentArtsBinding

class ArtsFragment : Fragment(R.layout.fragment_arts) {

    private var fragmentArtsBinding : FragmentArtsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentArtsBinding.bind(view)
        fragmentArtsBinding = binding

        binding.fab.setOnClickListener {
            findNavController().navigate(ArtsFragmentDirections.actionArtsFragmentToArtDetailsFragment())
        }
    }

    override fun onDestroyView() {
        fragmentArtsBinding = null
        super.onDestroyView()
    }
}