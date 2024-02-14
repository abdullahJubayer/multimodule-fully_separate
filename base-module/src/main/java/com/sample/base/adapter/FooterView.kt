package com.sample.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.base.R

class FooterView(
    private val retry: () -> Unit,
) : LoadStateAdapter<FooterView.LoadStateViewHolder>() {

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.tvErrorMsg.isVisible = loadState is LoadState.Error
        holder.progressBar.isVisible = loadState is LoadState.Loading

        if (loadState is LoadState.Error) {
            holder.tvErrorMsg.apply {
                loadState.error.localizedMessage?.apply {}
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        return LoadStateViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.pagination_loading_view, parent, false)
        )
    }

    class LoadStateViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvErrorMsg: TextView =view.findViewById<TextView>(R.id.load_state_errorMessage)
        val progressBar: ProgressBar =view.findViewById<ProgressBar>(R.id.load_state_progress)
    }
}