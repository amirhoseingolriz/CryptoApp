package ir.golriz.amirhosein.cryptoapp.di.module

import dagger.Module
import dagger.Provides
import ir.golriz.amirhosein.cryptoapp.model.api.ApiService
import ir.golriz.amirhosein.cryptoapp.model.repository.coins.CoinsRepository
import ir.golriz.amirhosein.cryptoapp.model.repository.coins.CoinsRepositoryImpl
import ir.golriz.amirhosein.cryptoapp.model.repository.news.NewsRepository
import ir.golriz.amirhosein.cryptoapp.model.repository.news.NewsRepositoryImpl
import ir.golriz.amirhosein.cryptoapp.utils.BASE_URL
import ir.golriz.amirhosein.cryptoapp.utils.REQUEST_HEADER
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    //HeaderRequest
    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor {
                val oldRequest = it.request()
                val newRequest = oldRequest.newBuilder()
                newRequest.addHeader("Authorization", REQUEST_HEADER)
                newRequest.method(oldRequest.method(), oldRequest.body())
                return@addInterceptor it.proceed(newRequest.build())
            }
            .build()
    }

    //Retrofit
    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    //ApiService
    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}