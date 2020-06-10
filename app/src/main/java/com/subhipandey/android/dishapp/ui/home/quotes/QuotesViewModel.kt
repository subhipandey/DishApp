package com.subhipandey.android.dishapp.ui.home.quotes

import androidx.lifecycle.ViewModel
import com.subhipandey.android.dishapp.data.repository.QuotesRepository
import com.subhipandey.android.dishapp.util.lazyDeferred

class QuotesViewModel(
    repository: QuotesRepository
) : ViewModel() {

    val quotes by lazyDeferred{
        repository.getQuotes()
    }
}