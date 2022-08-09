package hu.zsoltkiss.outgoings.ui.transactions

import androidx.compose.runtime.MutableState
import hu.zsoltkiss.outgoings.data.model.Category
import hu.zsoltkiss.outgoings.data.model.TransactionItem

interface TransactionsViewModel {
    val processingState: MutableState<Boolean>
    val currentFilterState: MutableState<List<Category>>
    val totalAmountState: MutableState<Int>
    val transactionListState: MutableState<List<TransactionItem>>

    fun fetchTransactions()
    fun addFilter(category: Category)
    fun removeFilter(category: Category)

}