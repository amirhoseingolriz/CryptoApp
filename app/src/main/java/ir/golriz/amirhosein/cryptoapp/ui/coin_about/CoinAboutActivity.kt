package ir.golriz.amirhosein.cryptoapp.ui.coin_about

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import ir.golriz.amirhosein.cryptoapp.R
import ir.golriz.amirhosein.cryptoapp.databinding.ActivityCoinAboutBinding
import ir.golriz.amirhosein.cryptoapp.model.data.ChartData
import ir.golriz.amirhosein.cryptoapp.model.data.CoinAboutData
import ir.golriz.amirhosein.cryptoapp.model.data.Coins
import ir.golriz.amirhosein.cryptoapp.utils.*
import javax.inject.Inject

class CoinAboutActivity : DaggerAppCompatActivity() {

    private lateinit var coin: Coins.Data
    private lateinit var aboutCoin: CoinAboutData.CoinAboutDataItem.Info
    private lateinit var binding: ActivityCoinAboutBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var coinAboutViewModel: CoinAboutViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        coinAboutViewModel =
            ViewModelProvider(this, viewModelFactory)[CoinAboutViewModel::class.java]

        //GetIntent
        if (Build.VERSION.SDK_INT >= 33) {

            coin =
                intent.getParcelableExtra(INTENT_KEY_SEND_COIN, Coins.Data::class.java)!!

            aboutCoin = intent.getParcelableExtra(
                INTENT_KEY_SEND_ABOUT_COIN, CoinAboutData.CoinAboutDataItem.Info::class.java
            ) ?: CoinAboutData.CoinAboutDataItem.Info()

        } else {

            coin = @Suppress("DEPRECATION") intent.getParcelableExtra(INTENT_KEY_SEND_COIN)!!

            aboutCoin =
                @Suppress("DEPRECATION") intent.getParcelableExtra(INTENT_KEY_SEND_ABOUT_COIN)
                    ?: CoinAboutData.CoinAboutDataItem.Info()
        }


        //Set Title Toolbar
        binding.toolbarCoin.toolbar.title = coin.coinInfo.fullName


        bindChartViewUi()
        initStatusCoin()
        initAboutCoin()

    }

    @SuppressLint("SetTextI18n")
    private fun bindChartViewUi() {

        binding.chartView.txtPriceCoin.text = coin.dISPLAY.uSD.pRICE
        binding.chartView.txtPercentChange.text = coin.dISPLAY.uSD.cHANGEPCT24HOUR + "%"
        binding.chartView.txtChangePrice.text = coin.dISPLAY.uSD.cHANGE24HOUR

        changeColorChangedPrice()

        initChart()

    }

    @SuppressLint("SetTextI18n")
    private fun initChart() {

        var period = HOUR12_CHART

        getChartData(period)

        binding.chartView.rgPeriodChart.setOnCheckedChangeListener { _, id ->
            when (id) {
                R.id.hour_period -> period = HOUR12_CHART
                R.id.day_period -> period = DAY_CHART
                R.id.week_period -> period = WEEK_CHART
                R.id.month_period -> period = MONTH_CHART
                R.id.month_3_period -> period = MONTH3_CHART
                R.id.year_period -> period = YEAR_CHART
                R.id.all_period -> period = ALL_CHART
            }

            getChartData(period)

        }

        //Show Price When Touch Chart
        binding.chartView.sparkViewChart.setScrubListener {

            if (it == null) {
                binding.chartView.txtPriceCoin.text = coin.dISPLAY.uSD.pRICE
            } else {
                binding.chartView.txtPriceCoin.text =
                    "$ " + (it as ChartData.Data.Data).open.toString()
            }

        }

    }

    private fun getChartData(period: String) {

        coinAboutViewModel.getChartDataFromServer(period, coin.coinInfo.name) { chartData ->
            binding.chartView.sparkViewChart.adapter =
                ChartAdapter(chartData.first, chartData.second?.close.toString())
        }

    }

    private fun changeColorChangedPrice() {
        //Change Color
        if (coin.dISPLAY.uSD.cHANGEPCT24HOUR.toDouble() > 0) {

            binding.chartView.txtArrowChange.text = "▲"
            binding.chartView.txtPercentChange.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.colorGain
                )
            )
            binding.chartView.txtArrowChange.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.colorGain
                )
            )
            binding.chartView.sparkViewChart.lineColor =
                ContextCompat.getColor(this, R.color.colorGain)

        } else if (coin.dISPLAY.uSD.cHANGEPCT24HOUR.toDouble() < 0) {

            binding.chartView.txtArrowChange.text = "▼"
            binding.chartView.txtPercentChange.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.colorLoss
                )
            )
            binding.chartView.txtArrowChange.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.colorLoss
                )
            )
            binding.chartView.sparkViewChart.lineColor =
                ContextCompat.getColor(this, R.color.colorLoss)

        }
    }

    private fun initStatusCoin() {

        binding.statusCoin.txtOpenValue.text = coin.dISPLAY.uSD.oPENDAY
        binding.statusCoin.txtHighValue.text = coin.dISPLAY.uSD.hIGHDAY
        binding.statusCoin.txtLowValue.text = coin.dISPLAY.uSD.lOWDAY
        binding.statusCoin.txtChangeTodayValue.text = coin.dISPLAY.uSD.cHANGEDAY
        binding.statusCoin.txtAlgorithmValue.text = coin.coinInfo.algorithm
        binding.statusCoin.txtTotalVolumeValue.text = coin.dISPLAY.uSD.tOTALVOLUME24H
        binding.statusCoin.txtMarketCapValue.text = coin.dISPLAY.uSD.mKTCAP
        binding.statusCoin.txtSupplyValue.text = coin.dISPLAY.uSD.sUPPLY

    }

    private fun initAboutCoin() {

        binding.aboutCoin.txtWebsiteValue.text = aboutCoin.web
        binding.aboutCoin.txtTwitterValue.text = aboutCoin.twt
        binding.aboutCoin.txtRedditValue.text = aboutCoin.reddit
        binding.aboutCoin.txtGithubValue.text = aboutCoin.github
        binding.aboutCoin.txtDescAbout.text = aboutCoin.desc

        binding.aboutCoin.txtWebsiteValue.setOnClickListener {
            if (aboutCoin.web != null && aboutCoin.web != "No Website") {
                aboutOpenUrl(aboutCoin.web!!)
            }
        }

        binding.aboutCoin.txtTwitterValue.setOnClickListener {
            if (aboutCoin.twt != null && aboutCoin.twt != "No Twitter") {
                aboutOpenUrl(BASE_TWITTER_URL + aboutCoin.twt)
            }
        }

        binding.aboutCoin.txtRedditValue.setOnClickListener {
            if (aboutCoin.reddit != null && aboutCoin.reddit != "No Reddit") {
                aboutOpenUrl(aboutCoin.reddit!!)
            }
        }

        binding.aboutCoin.txtGithubValue.setOnClickListener {
            if (aboutCoin.github != null && aboutCoin.github != "No Github") {
                aboutOpenUrl(aboutCoin.github!!)
            }
        }

    }

    private fun aboutOpenUrl(url: String) {

        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))

    }

}