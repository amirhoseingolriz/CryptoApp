package ir.golriz.amirhosein.cryptoapp.ui.coin_about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.golriz.amirhosein.cryptoapp.model.data.ChartData
import ir.golriz.amirhosein.cryptoapp.model.repository.chart.ChartRepository
import ir.golriz.amirhosein.cryptoapp.utils.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoinAboutViewModel
@Inject constructor(
    private val chartRepository: ChartRepository
) : ViewModel() {

    fun getChartDataFromServer(
        period: String,
        symbol: String,
        OnChartData: (Pair<List<ChartData.Data.Data>, ChartData.Data.Data?>) -> Unit
    ) {

        var historical = ""
        var limit = 30
        var aggregate = 1

        when (period) {

            HOUR12_CHART -> {
                historical = HISTO_MINUTE
                limit = 60
                aggregate = 12
            }

            DAY_CHART -> {
                historical = HISTO_HOUR
                limit = 24
            }

            WEEK_CHART -> {
                historical = HISTO_HOUR
                aggregate = 6
            }

            MONTH_CHART -> {
                historical = HISTO_DAY
            }

            MONTH3_CHART -> {
                historical = HISTO_DAY
                limit = 90
            }

            YEAR_CHART -> {
                historical = HISTO_DAY
                aggregate = 13
            }

            ALL_CHART -> {
                historical = HISTO_DAY
                limit = 2000
                aggregate = 30
            }

        }

        viewModelScope.launch(coroutineExceptionHandler) {

            OnChartData(chartRepository.getChartData(historical, symbol, limit, aggregate))

        }

    }


}