package ir.golriz.amirhosein.cryptoapp.model.repository.chart

import ir.golriz.amirhosein.cryptoapp.model.api.ApiService
import ir.golriz.amirhosein.cryptoapp.model.data.ChartData
import javax.inject.Inject

class ChartRepositoryImpl
@Inject constructor(
    private val apiService: ApiService
) : ChartRepository {

    override suspend fun getChartData(
        historical: String,
        fSymbol: String,
        limit: Int,
        aggregate: Int
    ): Pair<List<ChartData.Data.Data>, ChartData.Data.Data?> {

        //List Data Chart
        val data = apiService.getChartData(historical, fSymbol, limit, aggregate).data.data

        //Chart BaseLine
        val baseLine = data.maxByOrNull {
            it.close.toFloat()
        }

        return Pair(data, baseLine)

    }

}