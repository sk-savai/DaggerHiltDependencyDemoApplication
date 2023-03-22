package com.example.daggerhiltdependencydemoapplication.home.repository

import com.example.alokozapshopapplication.ui.fragment.homefragment.homemodelclass.HomeResponse
import com.example.daggerhiltdependencydemoapplication.network.Client.ApiInterface
import javax.inject.Inject

class HomeRepository @Inject constructor(private val apiInterface: ApiInterface) {
    suspend fun getHomeData(): HomeResponse {
        return apiInterface.getHomeData()
    }
}
