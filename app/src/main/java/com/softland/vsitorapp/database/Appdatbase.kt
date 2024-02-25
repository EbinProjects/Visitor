package com.softland.vsitorapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.softland.vsitorapp.database.dao.SaveEntryDao
import com.softland.vsitorapp.database.dao.SaveExitDao
import com.softland.vsitorapp.database.models.SaveEntryData
import com.softland.vsitorapp.database.models.SaveExitData
import com.softland.vsitorapp.ui.theme.Utilss.ConstantsValue


@Database(entities = [SaveEntryData::class,SaveExitData::class], version = 1, exportSchema = true)
abstract class Appdatbase : RoomDatabase() {

    abstract fun saveEntryDataDao() : SaveEntryDao
    abstract fun saveExitDao() : SaveExitDao

    companion object {
        @Volatile
        private var instance: Appdatbase? = null

        fun getInstance(context: Context): Appdatbase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): Appdatbase {
            return Room.databaseBuilder(context, Appdatbase::class.java, ConstantsValue.DATABASE_NAME)
                .allowMainThreadQueries().build()
        }
    }

}