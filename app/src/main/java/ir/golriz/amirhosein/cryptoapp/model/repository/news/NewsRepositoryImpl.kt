package ir.golriz.amirhosein.cryptoapp.model.repository.news

import ir.golriz.amirhosein.cryptoapp.model.api.ApiService
import ir.golriz.amirhosein.cryptoapp.model.data.News
import javax.inject.Inject

class NewsRepositoryImpl
@Inject constructor(
    private val apiService: ApiService
) : NewsRepository {

    override suspend fun getNews(setOrder: String): List<News.Data> {

        return apiService.getNews(setOrder).data

    }

}