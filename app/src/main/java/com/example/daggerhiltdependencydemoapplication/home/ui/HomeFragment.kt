package com.example.daggerhiltdependencydemoapplication.home.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.alokozapshopapplication.ui.fragment.homefragment.homemodelclass.HomeResponse
import com.example.daggerhiltdependencydemoapplication.R
import com.example.daggerhiltdependencydemoapplication.databinding.FragmentHomeBinding
import com.example.daggerhiltdependencydemoapplication.home.`interface`.HomeFragmentItemClickInterface
import com.example.daggerhiltdependencydemoapplication.home.adapter.HomeCategoryAdapter
import com.example.daggerhiltdependencydemoapplication.home.viewmodel.HomeViewModel
import com.example.daggerhiltdependencydemoapplication.network.Client.ResponseHandler
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList

@AndroidEntryPoint
class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var adapter: HomeCategoryAdapter
    private var list = ArrayList<HomeResponse.FeaturedCategory>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeViewModel.getHomeData()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        homeViewModel.homeDataResponse.observe(viewLifecycleOwner){
            if (it == null){
                return@observe
            }

            when(it){
                is ResponseHandler.Loading->{
                    binding.pbProgressBar.isVisible=true
                }
                is ResponseHandler.OnFailed ->{
                    binding.pbProgressBar.isVisible=false
                }
                is ResponseHandler.OnSuccessResponse -> {
                    binding.pbProgressBar.isVisible=false
                    it.response?.featuredCategories?.let { it1 -> list.addAll(it1) }
                    categoryItemClick()
                }
            }
        }
        return binding.root
    }

    private fun categoryItemClick() {
        adapter = HomeCategoryAdapter(
            requireContext(),
            object : HomeFragmentItemClickInterface {
                override fun onClickFeaturedCategory(
                    position: Int,
                    view: View,
                    data: HomeResponse.FeaturedCategory
                ) {
                    Toast.makeText(requireActivity(), data.categoryName, Toast.LENGTH_SHORT).show()
                }
            },
            list
        )
        binding.rvCategory.adapter = adapter
    }
}