package com.example.daggerhiltdependencydemoapplication.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alokozapshopapplication.ui.fragment.homefragment.homemodelclass.HomeResponse
import com.example.daggerhiltdependencydemoapplication.home.repository.HomeRepository
import com.example.daggerhiltdependencydemoapplication.network.Client.ResponseHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    val homeDataResponse = MutableLiveData<ResponseHandler<HomeResponse>>()

    fun getHomeData() = viewModelScope.launch {
        homeDataResponse.value = ResponseHandler.Loading
        homeDataResponse.value = ResponseHandler.OnSuccessResponse(repository.getHomeData())
    }
}