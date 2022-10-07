package ir.golriz.amirhosein.cryptoapp.model.repository.chart

import ir.golriz.amirhosein.cryptoapp.model.data.ChartData

interface ChartRepository {

    suspend fun getChartData(
        historical: String,
        fSymbol: String,
        limit: Int,
        aggregate: Int
    ): Pair<List<ChartData.Data.Data>, ChartData.Data.Data?>


}