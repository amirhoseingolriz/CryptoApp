package ir.golriz.amirhosein.cryptoapp.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerAppCompatActivity
import ir.golriz.amirhosein.cryptoapp.databinding.ActivityMainBinding
import ir.golriz.amirhosein.cryptoapp.model.data.CoinAboutData
import ir.golriz.amirhosein.cryptoapp.model.data.Coins
import ir.golriz.amirhosein.cryptoapp.model.data.News
import ir.golriz.amirhosein.cryptoapp.ui.coin_about.CoinAboutActivity
import ir.golriz.amirhosein.cryptoapp.utils.INTENT_KEY_SEND_ABOUT_COIN
import ir.golriz.amirhosein.cryptoapp.utils.INTENT_KEY_SEND_COIN
import ir.golriz.amirhosein.cryptoapp.utils.URL_COINS_SITE
import ir.golriz.amirhosein.cryptoapp.utils.ViewModelFactory
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), CoinListAdapter.OnCoinClicked {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mapCoinAbout: MutableMap<String, CoinAboutData.CoinAboutDataItem.Info>

    @Inject
    lateinit var glide: RequestManager

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        binding.swipeRefreshMarket.setOnRefreshListener {
            initUi()
        }

        getCurrencyInfoFromJson()

        //Open Website
        binding.btnMoreCoins.setOnClickListener {

            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(URL_COINS_SITE)))

        }

    }

    override fun onResume() {
        super.onResume()
        initUi()
    }

    private fun initUi() {

        bindNews()
        bindTopCoins()

    }

    private fun bindNews() {

        mainViewModel.getNews("popular") { listNews ->

            setRandomNews(mainViewModel.randomNews(listNews))

            binding.textNews.setOnClickListener {
                setRandomNews(mainViewModel.randomNews(listNews))
            }


        }
    }

    private fun setRandomNews(news: News.Data) {

        binding.textNews.text = news.title

        binding.imgNews.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(news.url)))
        }

    }

    private fun bindTopCoins() {

        mainViewModel.getTopCoins("USD", 10) { coins ->

            val adapter = CoinListAdapter(coins, glide, this)
            binding.recyclerCoins.adapter = adapter
            binding.recyclerCoins.layoutManager =
                LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            binding.swipeRefreshMarket.isRefreshing = false

        }

    }

    private fun getCurrencyInfoFromJson() {
        mainViewModel.getCurrencyInfoFromJson {
            mapCoinAbout = it
        }
    }

    //OnCoinClicked
    override fun onCoinClick(coin: Coins.Data) {
        val intent = Intent(this, CoinAboutActivity::class.java)
        intent.putExtra(INTENT_KEY_SEND_COIN, coin)
        intent.putExtra(INTENT_KEY_SEND_ABOUT_COIN, mapCoinAbout[coin.coinInfo.name])
        startActivity(intent)
    }


}