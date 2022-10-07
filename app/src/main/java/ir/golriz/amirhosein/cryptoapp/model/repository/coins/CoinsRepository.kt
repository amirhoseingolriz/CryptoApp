package ir.golriz.amirhosein.cryptoapp.model.repository.coins

import android.content.Context
import ir.golriz.amirhosein.cryptoapp.model.data.CoinAboutData
import ir.golriz.amirhosein.cryptoapp.model.data.Coins

interface CoinsRepository {

    suspend fun getTopCoins(symbol: String, limit: Int): List<Coins.Data>

    suspend fun getCurrencyInfoFromJson(): MutableMap<String, CoinAboutData.CoinAboutDataItem.Info>

}