package com.subhipandey.android.dishapp.ui.home.quotes

import com.subhipandey.android.dishapp.R
import com.subhipandey.android.dishapp.data.database.entities.Quote
import com.subhipandey.android.dishapp.databinding.ItemQuoteBinding
import com.xwray.groupie.databinding.BindableItem

class QuoteItem(
    private val quote: Quote
): BindableItem<ItemQuoteBinding>(){
    override fun getLayout() = R.layout.item_quote

    override fun bind(viewBinding: ItemQuoteBinding, position: Int) {
     viewBinding.setQuote(quote)
    }

}