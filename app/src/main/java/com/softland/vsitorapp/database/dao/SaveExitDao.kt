package com.softland.vsitorapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.softland.vsitorapp.database.models.SaveEntryData
import com.softland.vsitorapp.database.models.SaveExitData


@Dao
interface SaveExitDao {
    @Query("SELECT * FROM SaveExitData")
    fun getAll(): List<SaveExitData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(saveExitData: SaveExitData)

    @Delete
    fun delete(saveExitData: SaveExitData)  // Change parameter to non-nullable
}