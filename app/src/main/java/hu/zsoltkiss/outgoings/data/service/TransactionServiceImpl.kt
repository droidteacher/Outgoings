package hu.zsoltkiss.outgoings.data.service

import hu.zsoltkiss.outgoings.data.api.SprintformApi
import hu.zsoltkiss.outgoings.data.model.TransactionItem
import io.reactivex.rxjava3.core.Maybe
import javax.inject.Inject

class TransactionServiceImpl @Inject constructor(
    private val sprintformApi: SprintformApi
): TransactionService {


    override fun getTransactions(): Maybe<List<TransactionItem>> {
        return sprintformApi.getTransactions()
    }


}