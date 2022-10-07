package ir.golriz.amirhosein.cryptoapp.ui.coin_about

import com.robinhood.spark.SparkAdapter
import ir.golriz.amirhosein.cryptoapp.model.data.ChartData

class ChartAdapter(
    private val chartData: List<ChartData.Data.Data>,
    private val baseLine: String?
) : SparkAdapter() {

    override fun getCount(): Int {
        return chartData.size
    }

    override fun getItem(index: Int): ChartData.Data.Data {
        return chartData[index]
    }

    override fun getY(index: Int): Float {
        return chartData[index].close.toFloat()
    }

    override fun hasBaseLine(): Boolean {
        return true
    }

    override fun getBaseLine(): Float {
        return baseLine?.toFloat() ?: super.getBaseLine()
    }
}