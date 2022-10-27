package com.meprogrammer.extraaedge.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.meprogrammer.extraaedge.api.RocketsAPI
import com.meprogrammer.extraaedge.db.RocketDB
import com.meprogrammer.extraaedge.models.rocketsList.RocketsListDatum
import com.meprogrammer.extraaedge.utils.NetworkResult
import com.meprogrammer.extraaedge.utils.NetworkUtils
import dagger.hilt.android.qualifiers.ApplicationContext
import org.json.JSONObject
import javax.inject.Inject

class RocketRepository @Inject constructor( val rocketsAPI: RocketsAPI, val rocketDB: RocketDB? = null,  @ApplicationContext  val applicationContext:Context? = null) {

    private val _rocketsLiveData = MutableLiveData<NetworkResult<List<RocketsListDatum>>>()
    val rocketsLiveData: LiveData<NetworkResult<List<RocketsListDatum>>>
        get() = _rocketsLiveData

    private val _rocketDetailLiveData = MutableLiveData<NetworkResult<RocketsListDatum>>()
    val rocketDetailLiveData: LiveData<NetworkResult<RocketsListDatum>>
        get() = _rocketDetailLiveData


    private val _statusLiveData = MutableLiveData<NetworkResult<String>>()
    val statusLiveData: LiveData<NetworkResult<String>>
        get() = _statusLiveData

    suspend fun getRockets() {
        _rocketsLiveData.postValue(NetworkResult.Loading())
        if(NetworkUtils.isInternetAvailable(applicationContext!!)){
            val response = rocketsAPI.getRockets()
            if (response.isSuccessful && response.body() != null) {
                rocketDB!!.getRocketDao().saveRockets(response.body()!!)
                _rocketsLiveData.postValue(NetworkResult.Success(response.body()))
            } else if (response.errorBody() != null) {
                val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
                _rocketsLiveData.postValue(NetworkResult.Error(errorObj.getString("message")))
            } else {
                _rocketsLiveData.postValue(NetworkResult.Error("Something went wrong"))
            }
        }
        else{
            val rocketList: List<RocketsListDatum> = rocketDB!!.getRocketDao().getRockets()
            _rocketsLiveData.postValue(NetworkResult.Success(rocketList))
        }


    }

    suspend fun getRocketDetail(id: String) {
        _rocketDetailLiveData.postValue(NetworkResult.Loading())

        if(NetworkUtils.isInternetAvailable(applicationContext!!)){
            val response = rocketsAPI.getRocketsDetail(id)
            if (response.isSuccessful && response.body() != null) {
                _rocketDetailLiveData.postValue(NetworkResult.Success(response.body()!!))
            } else if (response.errorBody() != null) {
                val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
                _rocketDetailLiveData.postValue(NetworkResult.Error(errorObj.getString("message")))
            } else {
                _rocketDetailLiveData.postValue(NetworkResult.Error("Something went wrong"))

            }
        }
        else {
            //Get data from DB
            val rocketDetail = rocketDB!!.getRocketDao().getRocketDetail(id)
            _rocketDetailLiveData.postValue(NetworkResult.Success(rocketDetail))

        }

    }


}