package com.sample.example_module.demo.repo

import com.sample.base.network.BaseResponse
import com.sample.base.network.State
import com.sample.example_module.demo.model.DemoModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DemoLocalRepositoryImp @Inject constructor(
    private val ioDispatcher: CoroutineContext,
): DemoRepository {
    override fun getDemoList(): Flow<State<BaseResponse<List<DemoModel>>>> {
        return flow {
            try {
                val response= BaseResponse<List<DemoModel>>(message = "Data Fetch Success", data = arrayListOf(
                    DemoModel("One"), DemoModel("Two"), DemoModel("Three")
                ), success = true)
                emit(State.Success(response))
            }catch (e : Exception){
                emit(State.DataErrorMessage("Query Error"))
            }
        }.flowOn(ioDispatcher)

    }
}