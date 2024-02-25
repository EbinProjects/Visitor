package com.softland.vsitorapp.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SaveEntryData(
    @PrimaryKey
    val personId: Int? = null,
    val personName: String? = null,
    val personEntryTime: String? = null,
    val personPosition: String? = null,
    val entryStatus: Int? = null,
)
