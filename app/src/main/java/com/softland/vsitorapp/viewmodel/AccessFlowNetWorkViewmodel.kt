package com.softland.vsitorapp.viewmodel

import ResponseAtMillis
import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softland.vsitorapp.api.ApiRepository
import com.softland.vsitorapp.database.dao.SaveEntryDao
import com.softland.vsitorapp.database.dao.SaveExitDao
import com.softland.vsitorapp.database.models.SaveEntryData
import com.softland.vsitorapp.database.models.SaveExitData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AccessFlowNetWorkViewmodel @Inject constructor(
  private val apiRepository: ApiRepository,
  private val saveEntryDao: SaveEntryDao,
  private val saveExitDao: SaveExitDao,
   private val context: Context,
    private val sharedPreferences: SharedPreferences
):ViewModel() {

    val responseLiveData: MutableLiveData<ResponseAtMillis> by lazy {
        MutableLiveData<ResponseAtMillis>()
    }

    val responseEntryData: MutableLiveData<List<SaveEntryData>> by lazy {
        MutableLiveData<List<SaveEntryData>>()
    }

    val responseExitData: MutableLiveData<List<SaveExitData>> by lazy {
        MutableLiveData<List<SaveExitData>>()
    }


    @SuppressLint("CommitPrefEdits")
    fun collectEntryPersonsData(url: String, /*request: CheckDeviceStatusRequest*/) {
        viewModelScope.launch {
            val checkEntryRequest = apiRepository.entryPersonsData("$url/entry")
            if (checkEntryRequest.isSuccessful) {
//                responseLiveData.value = ResponseAtMillis("entry", checkEntryRequest.raw().receivedResponseAtMillis)
                for (item in checkEntryRequest.body()!!) {
                    val logon =sharedPreferences.edit()
                    logon.putBoolean("UserLogin",true)
                    when (item.entryStatus) {
                        0 -> {
                            saveEntryDao.insertItem(item)
                            responseEntryData.value = saveEntryDao.getAll()

                        }

                        1 -> {
                            val saveExit=SaveExitData(
                                item.personId,
                                item.personName,item.personEntryTime,item.personPosition,item.entryStatus
                            )
                            saveExitDao.insertItem(saveExit)
                            responseExitData.value = saveExitDao.getAll()
                        }
                        // Add more conditions as needed
                        else -> {
                            // Handle other cases or do nothing
                        }
                    }
                }
            }
        }


    }
}