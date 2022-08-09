package hu.zsoltkiss.outgoings.ui.transactions

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.zsoltkiss.outgoings.data.model.Category
import hu.zsoltkiss.outgoings.data.model.TransactionItem
import hu.zsoltkiss.outgoings.data.service.TransactionService
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModelImpl @Inject constructor(
    private val service: TransactionService
): ViewModel(), TransactionsViewModel {

    private val disposables = CompositeDisposable()
    private lateinit var allTransactions: List<TransactionItem>

    override val processingState: MutableState<Boolean> = mutableStateOf(false)
    override val currentFilterState: MutableState<List<Category>> = mutableStateOf(Category.values().toList())
    override val totalAmountState: MutableState<Int> = mutableStateOf(0)

    override val transactionListState: MutableState<List<TransactionItem>> = mutableStateOf(
        emptyList())


    init {
        processingState.value = true
        fetchTransactions()
    }


    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

    override fun addFilter(category: Category) {
        if (!currentFilterState.value.contains(category)) {
            val copy: MutableList<Category> = mutableListOf()
            copy.addAll(currentFilterState.value)
            copy.add(category)
            currentFilterState.value = copy
            updateListItems()
        }
    }

    override fun removeFilter(category: Category) {
        if(currentFilterState.value.contains(category)) {
            val copy: MutableList<Category> = mutableListOf()
            copy.addAll(currentFilterState.value)
            copy.remove(category)
            currentFilterState.value = copy
            updateListItems()
        }
    }

    override fun fetchTransactions() {
        service.getTransactions()
            .subscribeOn(Schedulers.io())
            .delay(1, TimeUnit.SECONDS)
            .subscribe { itemsFetched ->
                allTransactions = itemsFetched
                updateListItems()
                processingState.value = false
            }
            .addTo(disposables)
    }

    private fun updateListItems() {
        val updatedItems = allTransactions.filter { anItem ->
            currentFilterState.value.contains(anItem.category)
        }

        transactionListState.value = updatedItems
        updateCategoryAmount()
    }

    private fun updateCategoryAmount() {
        var sum = 0
        transactionListState.value.forEach {
            sum += it.amount
        }

        totalAmountState.value = sum
    }


}