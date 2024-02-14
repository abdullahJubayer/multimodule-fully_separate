package com.sample.base.adapter

import androidx.databinding.ViewDataBinding
import com.sample.base.model.Filterable

class BaseRecyclerAdapter<T : Filterable, VB : ViewDataBinding>(
    layoutId: Int,
    dataList: List<T> = ArrayList(),
    bindingCallback: BindingCallback<T,VB>,
    clickListener: ItemClickListener<T>
){
    private val adapter = BaseAdapter<T,VB>(layoutId,dataList,bindingCallback,clickListener)

    fun submitList(list: List<T>) {
        adapter.updateDataList(list)
    }

    fun filterData(query: CharSequence){
        adapter.filter(query = query)
    }

    fun getAdapter() = adapter
}