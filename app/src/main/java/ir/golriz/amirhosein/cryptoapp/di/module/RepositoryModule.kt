package ir.golriz.amirhosein.cryptoapp.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import ir.golriz.amirhosein.cryptoapp.model.api.ApiService
import ir.golriz.amirhosein.cryptoapp.model.repository.chart.ChartRepository
import ir.golriz.amirhosein.cryptoapp.model.repository.chart.ChartRepositoryImpl
import ir.golriz.amirhosein.cryptoapp.model.repository.coins.CoinsRepository
import ir.golriz.amirhosein.cryptoapp.model.repository.coins.CoinsRepositoryImpl
import ir.golriz.amirhosein.cryptoapp.model.repository.news.NewsRepository
import ir.golriz.amirhosein.cryptoapp.model.repository.news.NewsRepositoryImpl
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(apiService: ApiService): NewsRepository {
        return NewsRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideCoinsRepository(apiService: ApiService, context: Context): CoinsRepository {
        return CoinsRepositoryImpl(apiService, context)
    }

    @Singleton
    @Provides
    fun provideChartRepository(apiService: ApiService): ChartRepository {
        return ChartRepositoryImpl(apiService)
    }

}