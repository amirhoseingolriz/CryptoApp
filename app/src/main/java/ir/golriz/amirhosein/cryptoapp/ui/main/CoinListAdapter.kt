package ir.golriz.amirhosein.cryptoapp.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ir.golriz.amirhosein.cryptoapp.R
import ir.golriz.amirhosein.cryptoapp.databinding.ItemCoinListBinding
import ir.golriz.amirhosein.cryptoapp.model.data.Coins
import ir.golriz.amirhosein.cryptoapp.utils.BASE_IMG_URL

class CoinListAdapter(
    private val coins: List<Coins.Data>,
    private val glide: RequestManager,
    private val onCoinClicked: OnCoinClicked
) :
    RecyclerView.Adapter<CoinListAdapter.CoinViewHolder>() {

    private lateinit var binding: ItemCoinListBinding

    inner class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bindData(coin: Coins.Data) {

            binding.txtTitleItemCoin.text = coin.coinInfo.fullName
            binding.txtPriceItemCoin.text = coin.dISPLAY.uSD.pRICE
            binding.txtPercentChangeItem.text = coin.dISPLAY.uSD.cHANGEPCT24HOUR + "%"
            binding.txtMarketCapItem.text = coin.dISPLAY.uSD.mKTCAP



            glide.load(BASE_IMG_URL + coin.coinInfo.imageUrl)
                .into(binding.imgCoin)


            //Change Color
            if (coin.dISPLAY.uSD.cHANGEPCT24HOUR.toFloat() > 0) {
                binding.txtPercentChangeItem.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorGain
                    )
                )
            } else if (coin.dISPLAY.uSD.cHANGEPCT24HOUR.toFloat() < 0) {
                binding.txtPercentChangeItem.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorLoss
                    )
                )
            }


            //ClickTiItemCoin
            binding.layoutListCoin.setOnClickListener {

                onCoinClicked.onCoinClick(coin)

            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        binding = ItemCoinListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bindData(coins[position])
    }

    override fun getItemCount(): Int {
        return coins.size
    }

    interface OnCoinClicked {
        fun onCoinClick(coin: Coins.Data)
    }

}