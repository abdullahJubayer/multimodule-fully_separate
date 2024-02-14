package com.sample.example_module.demo.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.base.network.BaseResponse
import com.sample.base.network.State
import com.sample.example_module.demo.model.DemoModel
import com.sample.example_module.demo.repo.DemoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DemoViewModel @Inject constructor(private val repository: DemoRepository) : ViewModel() {

    private val demoLiveDataPrivate = MutableLiveData<State<BaseResponse<List<DemoModel>>>>()
    val demoLiveData: LiveData<State<BaseResponse<List<DemoModel>>>> get() = demoLiveDataPrivate


    fun getDemoList(){
        viewModelScope.launch {
            demoLiveDataPrivate.value = State.Loading()
            repository.getDemoList().collect {
                demoLiveDataPrivate.value = it
            }
        }
    }

}