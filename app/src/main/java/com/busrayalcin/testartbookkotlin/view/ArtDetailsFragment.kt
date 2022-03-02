package com.busrayalcin.testartbookkotlin.view

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.busrayalcin.testartbookkotlin.R
import com.busrayalcin.testartbookkotlin.databinding.FragmentArtDetailsBinding

class ArtDetailsFragment : Fragment(R.layout.fragment_art_details) {

    private var fragmentDetailArtBinding : FragmentArtDetailsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentArtDetailsBinding.bind(view)
        fragmentDetailArtBinding = binding

        binding.artImageView.setOnClickListener {
            findNavController().navigate(ArtDetailsFragmentDirections.actionArtDetailsFragmentToImageAPIFragment())
        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }

    override fun onDestroyView() {
        fragmentDetailArtBinding = null
        super.onDestroyView()
    }
}