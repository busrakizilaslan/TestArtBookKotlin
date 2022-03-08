package com.busrayalcin.testartbookkotlin.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.busrayalcin.testartbookkotlin.adapter.ArtRecyclerAdapter
import com.busrayalcin.testartbookkotlin.adapter.ImageRecyclerAdapter
import javax.inject.Inject

class ArtFragmentFactory @Inject constructor(
    private val artRecyclerAdapter: ArtRecyclerAdapter,
    private val glide : RequestManager,
    private val imageRecyclerAdapter: ImageRecyclerAdapter
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {

        return when(className){
            ArtsFragment::class.java.name -> ArtsFragment(artRecyclerAdapter)
            ArtDetailsFragment::class.java.name -> ArtDetailsFragment(glide)
            ImageAPIFragment::class.java.name -> ImageAPIFragment(imageRecyclerAdapter)
            else -> super.instantiate(classLoader, className)
        }
    }
}