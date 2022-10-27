package com.meprogrammer.extraaedge.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meprogrammer.extraaedge.repository.RocketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RocketsViewModel @Inject constructor(private val rocketRepository: RocketRepository): ViewModel() {

    val rocketsLiveData get() = rocketRepository.rocketsLiveData
    val rocketDetailLiveData get() = rocketRepository.rocketDetailLiveData
    val statusLiveData get() = rocketRepository.statusLiveData


    fun getRocketsList(){
        viewModelScope.launch {
            rocketRepository.getRockets()
        }
    }



    fun getRocketDetail(id: String){
        viewModelScope.launch {
            rocketRepository.getRocketDetail(id)
        }
    }




}