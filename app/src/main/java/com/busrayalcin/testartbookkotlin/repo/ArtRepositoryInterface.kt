package com.busrayalcin.testartbookkotlin.repo

import androidx.lifecycle.LiveData
import com.busrayalcin.testartbookkotlin.model.ImageResponse
import com.busrayalcin.testartbookkotlin.room.Art
import com.busrayalcin.testartbookkotlin.util.Resource

interface ArtRepositoryInterface {

    suspend fun insertArt(art : Art)

    suspend fun deleteArt(art: Art)

    fun getArt() : LiveData<List<Art>>

    suspend fun searchImage(imageString : String) : Resource<ImageResponse>
}