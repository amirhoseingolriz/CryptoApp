package ir.golriz.amirhosein.cryptoapp.model.data


import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("Data")
    val `data`: List<Data>,
) {
    data class Data(

        @SerializedName("title")
        val title: String,
        @SerializedName("url")
        val url: String

    )
}