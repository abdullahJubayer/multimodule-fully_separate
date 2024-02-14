package com.sample.example_module.demo.repo

import com.sample.base.network.BaseResponse
import com.sample.base.network.State
import com.sample.base.network.State.DataErrorMessage
import com.sample.base.utils.NetworkConnectivity
import com.sample.example_module.demo.model.DemoModel
import com.sample.example_module.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DemoRemoteRepositoryImp @Inject constructor(
    private val ioDispatcher: CoroutineContext,
    private val apiService: ApiService,
    private val networkConnectivity: NetworkConnectivity
): DemoRepository {
    override fun getDemoList(): Flow<State<BaseResponse<List<DemoModel>>>> {
        return flow {
            if (!networkConnectivity.isConnected())
                emit(DataErrorMessage("No Internet Connection"))
            else
                try {
                    val response = apiService.getDemoList()
                    if (response.success)
                        emit(State.Success(response))
                    else
                        emit(DataErrorMessage(response.message))
                } catch (ex: Exception) {
                    emit(DataErrorMessage(ex.message.toString()))
                }
        }.flowOn(ioDispatcher)

    }
}