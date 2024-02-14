package com.sample.base.adapter

import androidx.databinding.ViewDataBinding

interface ItemClickListener<T> {
    fun onItemClick(data : T)
}

interface BindingCallback<T,VB : ViewDataBinding> {
    fun bindData(binder: VB, model: T)
}