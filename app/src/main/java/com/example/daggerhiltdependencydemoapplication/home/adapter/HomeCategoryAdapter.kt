package com.example.daggerhiltdependencydemoapplication.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.alokozapshopapplication.ui.fragment.homefragment.homemodelclass.HomeResponse
import com.example.daggerhiltdependencydemoapplication.R
import com.example.daggerhiltdependencydemoapplication.databinding.RecyclarViewHomeCategoryBinding
import com.example.daggerhiltdependencydemoapplication.home.`interface`.HomeFragmentItemClickInterface

class HomeCategoryAdapter(

    private val context: Context,
    private val listener: HomeFragmentItemClickInterface,
    private var categoryData:ArrayList<HomeResponse.FeaturedCategory>
):
    RecyclerView.Adapter<HomeCategoryAdapter.CategoryViewHolder>() {

    private lateinit var binding: RecyclarViewHomeCategoryBinding


    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):CategoryViewHolder {
        binding =
            RecyclarViewHomeCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder:CategoryViewHolder, position: Int) {
        binding.homeCategoryItemModel =categoryData[position]

        binding.cvCardItem.setOnClickListener{
            listener.onClickFeaturedCategory(position,it,categoryData[position])
        }


       /* Glide.with(context)
            .load(categoryData[position].url)
            .placeholder(R.drawable.ic_launcher_background)
            .centerCrop()
            .error(R.drawable.ic_launcher_background)
            .into(binding.ivItemImage)
*/
    }

    override fun getItemCount(): Int {
        Log.e("Tag", categoryData.size.toString())
        return categoryData.size

    }
    override fun getItemViewType(position: Int): Int {
        return position
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateCategoryItemData(list: ArrayList<HomeResponse.FeaturedCategory>) {
        this.categoryData = list
        this.notifyDataSetChanged()
    }


}