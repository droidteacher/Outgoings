package hu.zsoltkiss.outgoings.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.zsoltkiss.outgoings.data.service.TransactionService
import hu.zsoltkiss.outgoings.data.service.TransactionServiceImpl

@InstallIn(SingletonComponent::class)
@Module
abstract class ServiceModule {

    @Binds
    abstract fun bindTransactionService(impl: TransactionServiceImpl): TransactionService
}