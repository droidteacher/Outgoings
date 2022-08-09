package hu.zsoltkiss.outgoings.data.service

import hu.zsoltkiss.outgoings.data.model.TransactionItem
import io.reactivex.rxjava3.core.Maybe

interface TransactionService {

    fun getTransactions(): Maybe<List<TransactionItem>>

}