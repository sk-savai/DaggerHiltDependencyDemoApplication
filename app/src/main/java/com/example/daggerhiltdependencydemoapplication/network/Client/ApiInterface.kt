package com.example.daggerhiltdependencydemoapplication.network.Client

import com.example.alokozapshopapplication.ui.fragment.homefragment.homemodelclass.HomeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface ApiInterface {
    @GET("mobikulhttp/catalog/homepagedata")
    suspend fun getHomeData(
        @Query("eTag") eTag: String = "",
        @Query("websiteId") websiteId: String = "1",
        @Query("storeId") storeId: String = "1",
        @Query("quoteId") quoteId: String = "",
        @Query("customerToken") customerToken: String = "",
        @Query("currency") currency: String = "AED",
        @Query("width") width: String = "1440",
        @Query("mFactor") mFactor: String = "3.5",
        @Query("isFromUrl") isFromUrl: String = "0",
        @Query("url") url: String = "",
        @Query("pageNumber") pageNumber: String = "1",
        ): HomeResponse


}