package com.sample.example_module.demo.repo

import com.sample.base.network.BaseResponse
import com.sample.base.network.State
import com.sample.example_module.demo.model.DemoModel
import kotlinx.coroutines.flow.Flow

interface DemoRepository {
    fun getDemoList () : Flow<State<BaseResponse<List<DemoModel>>>>
}