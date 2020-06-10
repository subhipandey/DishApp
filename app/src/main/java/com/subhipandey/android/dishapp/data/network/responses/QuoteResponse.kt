package com.subhipandey.android.dishapp.data.network.responses

import com.subhipandey.android.dishapp.data.database.entities.Quote

data class QuoteResponse (
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)