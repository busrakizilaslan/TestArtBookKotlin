package com.busrayalcin.testartbookkotlin.model

data class ImageResponse(
      val hits : List<ImageResult>,
      val total : Int,
      val totalHits : Int
)
