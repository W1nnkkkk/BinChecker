package com.w1nkkkk.binchecker.di

import com.w1nkkkk.binchecker.data.datasource.remote.BinRemoteDatasource
import com.w1nkkkk.binchecker.data.datasource.remote.BinRemoteDatasourceTestImpl
import com.w1nkkkk.binchecker.data.repository.BinRepositoryImpl
import com.w1nkkkk.binchecker.domain.BinRepository
import com.w1nkkkk.binchecker.presentation.viewmodels.BinViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BindModule {

    @Provides
    fun provideBinRemoteDatasource() : BinRemoteDatasource {
        return BinRemoteDatasourceTestImpl()
    }

    @Provides
    fun provideBinRepository(binRemoteDatasource: BinRemoteDatasource) : BinRepository {
        return BinRepositoryImpl(binRemoteDatasource)
    }

    @Provides
    @Singleton
    fun provideBinViewModel(repository: BinRepository) : BinViewModel {
        return BinViewModel(repository)
    }
}