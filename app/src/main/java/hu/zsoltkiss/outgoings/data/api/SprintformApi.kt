package hu.zsoltkiss.outgoings.data.api

import hu.zsoltkiss.outgoings.data.model.TransactionItem
import io.reactivex.rxjava3.core.Maybe
import retrofit2.http.GET

interface SprintformApi {

    @GET("transactions.json")
    fun getTransactions(): Maybe<List<TransactionItem>>

}