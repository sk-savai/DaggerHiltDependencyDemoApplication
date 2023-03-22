package com.example.daggerhiltdependencydemoapplication.home.`interface`

import android.view.View
import com.example.alokozapshopapplication.ui.fragment.homefragment.homemodelclass.HomeResponse

interface HomeFragmentItemClickInterface {
    fun onClickFeaturedCategory(position: Int, view: View, data: HomeResponse.FeaturedCategory)
}