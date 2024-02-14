package com.sample.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sample.base.model.Filterable


open class BaseAdapter<T : Filterable, VB : ViewDataBinding>(
                                                          private val layoutId: Int,
                                                          private var dataList : List<T> = ArrayList(),
                                                          private val bindingCallback: BindingCallback<T,VB>,
                                                          private val clickListener: ItemClickListener<T>
) : ListAdapter<T,BaseAdapter<T,VB>.BaseViewHolder>(DiffCallback<T>()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return BaseViewHolder(v)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindData(item)
    }

    fun updateDataList(dataList: List<T>){
        this.dataList= dataList
        submitList(dataList)
    }

    inner class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var binding: VB
        init {
            binding = DataBindingUtil.bind(view)!!
            binding.root.setOnClickListener {
                clickListener.onItemClick(getItem(absoluteAdapterPosition))
            }
        }
        fun bindData(model: T) {
            bindingCallback.bindData(binding, model)
        }
    }


    fun filter(query: CharSequence) {
        val list = ArrayList<T>()

        if (query.toString().isNotEmpty()) {
            for (filterList in dataList) {
                if (filterList.matcher(query.toString()))
                    list.add(filterList)
            }
        } else {
            list.addAll(dataList)
        }
        submitList(list)
    }

    class DiffCallback<T : Filterable> : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem.toString() == newItem.toString()
        }
    }
}