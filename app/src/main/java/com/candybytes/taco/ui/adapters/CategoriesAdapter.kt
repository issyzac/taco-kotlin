package com.candybytes.taco.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.candybytes.taco.databinding.ItemCategoryBinding
import com.candybytes.taco.vo.Category

class CategoriesAdapter : ListAdapter<Category, CategoriesAdapter.CategoryViewHolder>(Companion){

    class CategoryViewHolder(val binding : ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    companion object : DiffUtil.ItemCallback<Category>(){
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean = oldItem === newItem
        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean = oldItem.id == newItem.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, vieType: Int) : CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryBinding.inflate(layoutInflater)

        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int){
        val currentCategory = getItem(position)
        holder.binding.category = currentCategory
        holder.binding.executePendingBindings()
    }

}