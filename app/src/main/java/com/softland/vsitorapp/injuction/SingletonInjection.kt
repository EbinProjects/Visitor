package com.softland.vsitorapp.injuction

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.softland.vsitorapp.api.ApiServices
import com.softland.vsitorapp.database.Appdatbase
import com.softland.vsitorapp.database.dao.SaveEntryDao
import com.softland.vsitorapp.database.dao.SaveExitDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class SingletonInjection {

    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }
    @Singleton
    @Provides
    fun provideSharePreferences(@ApplicationContext context: Context) : SharedPreferences{
        return context.getSharedPreferences("MyPrefs", android.content.Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideAppdatabase(@ApplicationContext context: Context): Appdatbase{
        return Appdatbase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideApiinterfaces(@ApplicationContext context: Context): ApiServices{
        return ApiServices.createAccessFlow()
    }

    @Provides
    fun provideSaveEntryData(appdatbase: Appdatbase):SaveEntryDao{
        return appdatbase.saveEntryDataDao()
    }

    @Provides
    fun provideSaveExitData(appdatbase: Appdatbase):SaveExitDao{
        return appdatbase.saveExitDao()
    }
}