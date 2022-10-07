package ir.golriz.amirhosein.cryptoapp.model.api

import ir.golriz.amirhosein.cryptoapp.model.data.ChartData
import ir.golriz.amirhosein.cryptoapp.model.data.Coins
import ir.golriz.amirhosein.cryptoapp.model.data.News
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    //@Headers("authorization: Apikey 365527be297a8c127a61bd31682b3e985c4a99ec71b0b6e5a647af355ad660bc")
    @GET("v2/news/")
    suspend fun getNews(@Query("sortOrder") sortOrder: String): News


    @GET("top/totaltoptiervolfull")
    suspend fun getTopList(@Query("tsym") symbol: String, @Query("limit") limit: Int): Coins


    @GET("v2/{period}")
    suspend fun getChartData(
        @Path("period") period: String,
        @Query("fsym") fSymbol: String,
        @Query("limit") limit: Int,
        @Query("aggregate") aggregate: Int,
        @Query("tsym") tSymbol: String = "USD"
    ): ChartData


}