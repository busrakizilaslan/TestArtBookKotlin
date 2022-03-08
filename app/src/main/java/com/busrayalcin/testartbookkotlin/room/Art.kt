package com.busrayalcin.testartbookkotlin.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "arts")
data class Art(
    var name : String,
    var artistName : String,
    var year : Int,
    var ImageUrl : String,
    @PrimaryKey(autoGenerate = true)
    var Id : Int? = null
)