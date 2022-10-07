package ir.golriz.amirhosein.cryptoapp.model.repository.news

import ir.golriz.amirhosein.cryptoapp.model.data.News

interface NewsRepository {

    suspend fun getNews(setOrder:String): List<News.Data>

}