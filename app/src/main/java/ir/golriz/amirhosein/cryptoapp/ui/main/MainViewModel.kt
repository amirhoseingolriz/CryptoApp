package ir.golriz.amirhosein.cryptoapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.golriz.amirhosein.cryptoapp.model.data.CoinAboutData
import ir.golriz.amirhosein.cryptoapp.model.data.Coins
import ir.golriz.amirhosein.cryptoapp.model.data.News
import ir.golriz.amirhosein.cryptoapp.model.repository.coins.CoinsRepository
import ir.golriz.amirhosein.cryptoapp.model.repository.news.NewsRepository
import ir.golriz.amirhosein.cryptoapp.utils.coroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val newsRepository: NewsRepository,
    private val coinsRepository: CoinsRepository
) : ViewModel() {


    fun getNews(setOrder: String, OnGetNews: (List<News.Data>) -> Unit) {
        viewModelScope.launch(coroutineExceptionHandler) {
            OnGetNews(newsRepository.getNews(setOrder))
        }

    }

    fun randomNews(listNews: List<News.Data>): News.Data {
        val rand = (0..listNews.size).random()
        return listNews[rand]
    }


    fun getTopCoins(symbol: String, limit: Int, OnGetCoins: (List<Coins.Data>) -> Unit) {
        viewModelScope.launch(coroutineExceptionHandler) {

            OnGetCoins(coinsRepository.getTopCoins(symbol, limit))

        }
    }

    fun getCurrencyInfoFromJson(OnGetCurrencyInfo: (MutableMap<String, CoinAboutData.CoinAboutDataItem.Info>) -> Unit) {

        viewModelScope.launch(coroutineExceptionHandler) {
            OnGetCurrencyInfo(coinsRepository.getCurrencyInfoFromJson())
        }

    }


}