package com.subhipandey.android.dishapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.subhipandey.android.dishapp.data.database.entities.Quote

@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllQuotes(quotes: List<Quote>)


    @Query("SELECT * FROM Quote")
    fun getQuotes() : LiveData<List<Quote>>
}