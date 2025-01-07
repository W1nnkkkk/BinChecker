package com.w1nkkkk.binchecker.di

import android.content.Context
import com.w1nkkkk.binchecker.data.datasource.local.HistoryLocalDatasource
import com.w1nkkkk.binchecker.data.datasource.local.HistoryLocalDatasourceImpl
import com.w1nkkkk.binchecker.data.repository.HistoryRepositoryImpl
import com.w1nkkkk.binchecker.domain.HistoryRepository
import com.w1nkkkk.binchecker.presentation.viewmodels.HistoryViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HistoryModule {

    @Provides
    fun provideHistoryLocalDatasource(context: Context) : HistoryLocalDatasource {
        return HistoryLocalDatasourceImpl(context)
    }

    @Provides
    fun provideHistoryRepository(datasource : HistoryLocalDatasource) : HistoryRepository {
        return HistoryRepositoryImpl(datasource)
    }

    @Provides
    @Singleton
    fun providesHistoryViewModel(repository: HistoryRepository) : HistoryViewModel {
        return HistoryViewModel(repository)
    }
}