package com.sample.example_module.demo.model

import com.sample.base.model.Filterable

data class DemoModel(
    val data :String,
) : Filterable() {
    override fun filterKey(): String {
        return data
    }
}
