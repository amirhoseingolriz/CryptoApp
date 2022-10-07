package ir.golriz.amirhosein.cryptoapp.model.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

class CoinAboutData : ArrayList<CoinAboutData.CoinAboutDataItem>() {
    @Parcelize
    data class CoinAboutDataItem(
        @SerializedName("currencyName")
        val currencyName: String,
        @SerializedName("info")
        val info: Info
    ) : Parcelable {
        @Parcelize
        data class Info(
            @SerializedName("desc")
            val desc: String? = "No Description",
            @SerializedName("web")
            val web: String? = "No Website",
            @SerializedName("twt")
            val twt: String? = "No Twitter",
            @SerializedName("reddit")
            val reddit: String? = "No Reddit",
            @SerializedName("github")
            val github: String? = "No Github"
        ) : Parcelable
    }
}
