package com.candybytes.taco.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.candybytes.taco.databinding.FragmentCategoryListBinding
import com.candybytes.taco.ui.adapters.CategoriesAdapter
import com.candybytes.taco.ui.vm.CategoriesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryListFragment : Fragment() {

    private val viewModel: CategoriesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {



        return FragmentCategoryListBinding.inflate(layoutInflater, container, false).apply {
            viewModel = this@CategoryListFragment.viewModel
            lifecycleOwner = this@CategoryListFragment
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoryAdapter = CategoriesAdapter()

        val binding = DataBindingUtil.findBinding<FragmentCategoryListBinding>(view)
        binding?.adapter = categoryAdapter

        viewModel.allCategoriesData.observe(viewLifecycleOwner, Observer {
            it.let(categoryAdapter::submitList)
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
