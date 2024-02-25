package com.softland.vsitorapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.softland.vsitorapp.database.models.SaveEntryData


@Dao
interface SaveEntryDao {
    @Query("SELECT * FROM SaveEntryData")
    fun getAll(): List<SaveEntryData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(saveEntryData: SaveEntryData)

    @Delete
    fun delete(saveEntryData: SaveEntryData)  // Change parameter to non-nullable
}