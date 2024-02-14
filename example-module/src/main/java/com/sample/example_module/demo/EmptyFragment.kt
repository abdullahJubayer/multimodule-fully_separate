package com.sample.example_module.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.myapplication.example.R
import com.example.myapplication.example.databinding.DemoViewBinding
import com.example.myapplication.example.databinding.FragmentEmptyBinding
import com.sample.base.adapter.BaseRecyclerAdapter
import com.sample.base.adapter.BindingCallback
import com.sample.base.adapter.ItemClickListener
import com.sample.base.network.State
import com.sample.base.ui.BaseFragment
import com.sample.example_module.demo.model.DemoModel
import com.sample.example_module.demo.view_model.DemoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmptyFragment : BaseFragment() {
    private val demoViewModel by viewModels<DemoViewModel>()
    private lateinit var binding: FragmentEmptyBinding
    private lateinit var adapter: BaseRecyclerAdapter<DemoModel, DemoViewBinding>

    override fun bindObservers() {
        demoViewModel.demoLiveData.observe(this) {
            when (it) {
                is State.Loading -> {
                    binding.progressBar.isVisible = true
                }
                is State.Success -> {
                    binding.progressBar.isVisible = false
                    if (this::adapter.isInitialized) {
                        it.data?.data?.let { dataList ->
                            adapter.submitList(dataList)
                        }
                    }
                }
                is State.DataErrorMessage -> {
                    binding.progressBar.isVisible = false
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEmptyBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        demoViewModel.getDemoList()

        adapter = BaseRecyclerAdapter<DemoModel, DemoViewBinding>(R.layout.demo_view,
            emptyList(), object : BindingCallback<DemoModel, DemoViewBinding> {
                override fun bindData(binder: DemoViewBinding, model: DemoModel) {
                    binder.data = model
                }
            }, object : ItemClickListener<DemoModel> {
                override fun onItemClick(data: DemoModel) {
                }
            }
        )

        binding.demoList.adapter = adapter.getAdapter()
    }

}