package com.subhipandey.android.dishapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.subhipandey.android.dishapp.data.database.AppDatabase
import com.subhipandey.android.dishapp.data.database.entities.Quote
import com.subhipandey.android.dishapp.data.network.Api
import com.subhipandey.android.dishapp.data.network.SafeApiRequest
import com.subhipandey.android.dishapp.util.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuotesRepository(
    private val api: Api,
    private val db: AppDatabase
) : SafeApiRequest() {
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.observeForever {
            saveQuotes(it)
        }
    }

    suspend fun getQuotes(): LiveData<List<Quote>>{
        return withContext(Dispatchers.IO){
            fetchQuotes()
            db.getQuoteDao().getQuotes()
        }
    }

    private suspend fun fetchQuotes() {
        if (isFetchNeeded()) {
            val response = apiRequest { api.getQuotes() }
            quotes.postValue(response.quotes)

        }
    }

    private fun isFetchNeeded(): Boolean {
        return true

    }

    private fun saveQuotes(quotes: List<Quote>) {
        Coroutines.io {
            db.getQuoteDao().saveAllQuotes(quotes)
        }

    }
}