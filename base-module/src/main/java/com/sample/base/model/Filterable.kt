package com.sample.base.model

import java.util.Locale

abstract class Filterable {
    abstract fun filterKey() : String

    fun matcher(query: String): Boolean {
        return filterKey().lowercase(Locale.getDefault()).contains(query.lowercase(Locale.getDefault()))
    }
}