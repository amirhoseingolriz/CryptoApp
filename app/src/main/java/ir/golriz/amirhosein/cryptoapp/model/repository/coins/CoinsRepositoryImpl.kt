package ir.golriz.amirhosein.cryptoapp.model.repository.coins

import android.content.Context
import com.google.gson.Gson
import ir.golriz.amirhosein.cryptoapp.R
import ir.golriz.amirhosein.cryptoapp.model.api.ApiService
import ir.golriz.amirhosein.cryptoapp.model.data.CoinAboutData
import ir.golriz.amirhosein.cryptoapp.model.data.Coins
import javax.inject.Inject

class CoinsRepositoryImpl
@Inject constructor(
    private val apiService: ApiService,
    private val context: Context
) : CoinsRepository {

    override suspend fun getTopCoins(symbol: String, limit: Int): List<Coins.Data> {
        return apiService.getTopList(symbol, limit).data
    }

    override suspend fun getCurrencyInfoFromJson(): MutableMap<String, CoinAboutData.CoinAboutDataItem.Info> {

        val file =
            context.resources.openRawResource(R.raw.currencyinfo).bufferedReader().use {
                it.readText()
            }

        val mapCoinAbout = mutableMapOf<String, CoinAboutData.CoinAboutDataItem.Info>()

        val gson = Gson()
        val dataAbout = gson.fromJson(file, CoinAboutData::class.java)

        dataAbout.forEach {

            mapCoinAbout[it.currencyName] = it.info

        }

        return mapCoinAbout
    }


}
