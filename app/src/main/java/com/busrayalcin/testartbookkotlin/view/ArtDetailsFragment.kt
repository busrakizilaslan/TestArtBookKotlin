package com.busrayalcin.testartbookkotlin.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.busrayalcin.testartbookkotlin.R
import com.busrayalcin.testartbookkotlin.databinding.FragmentArtDetailsBinding
import com.busrayalcin.testartbookkotlin.util.Status
import com.busrayalcin.testartbookkotlin.viewModel.ArtViewModel
import javax.inject.Inject

class ArtDetailsFragment @Inject constructor(
    val glide: RequestManager
) : Fragment(R.layout.fragment_art_details) {

    lateinit var viewModel: ArtViewModel

    private var fragmentDetailArtBinding : FragmentArtDetailsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(ArtViewModel::class.java)

        val binding = FragmentArtDetailsBinding.bind(view)
        fragmentDetailArtBinding = binding

        subscribeToObservers()

        binding.artImageView.setOnClickListener {
            findNavController().navigate(ArtDetailsFragmentDirections.actionArtDetailsFragmentToImageAPIFragment())
        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)

        binding.saveButton.setOnClickListener {
            viewModel.makeArt(binding.nameText.toString(),
                binding.artistText.toString(),
                binding.yearText.toString())
        }
    }

    private fun subscribeToObservers(){
        viewModel.selectedImageUrl.observe(viewLifecycleOwner, Observer { url ->
            fragmentDetailArtBinding?.let {
                glide.load(url).into(it.artImageView)
            }
        })
        viewModel.insertArtMessage.observe(viewLifecycleOwner, Observer {
            when(it.status){
                Status.SUCCESS -> {
                    Toast.makeText(requireContext(), "Success", Toast.LENGTH_LONG).show()
                    findNavController().popBackStack()
                    viewModel.resetInsertArtMsg()
                }
                Status.ERROR -> {
                    Toast.makeText(requireContext(), it.message ?: "Error", Toast.LENGTH_LONG).show()
                }
                Status.LOADING -> {

                }
            }
        })

    }

    override fun onDestroyView() {
        fragmentDetailArtBinding = null
        super.onDestroyView()
    }
}