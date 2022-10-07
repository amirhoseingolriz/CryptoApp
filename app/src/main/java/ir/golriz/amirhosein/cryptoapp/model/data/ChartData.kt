package ir.golriz.amirhosein.cryptoapp.model.data


import com.google.gson.annotations.SerializedName

data class ChartData(
    @SerializedName("Data")
    val `data`: Data
) {
    data class Data(
        @SerializedName("Aggregated")
        val aggregated: Boolean,
        @SerializedName("TimeFrom")
        val timeFrom: Int,
        @SerializedName("TimeTo")
        val timeTo: Int,
        @SerializedName("Data")
        val `data`: List<Data>
    ) {
        data class Data(
            @SerializedName("time")
            val time: Int,
            @SerializedName("high")
            val high: Double,
            @SerializedName("low")
            val low: Double,
            @SerializedName("open")
            val `open`: Double,
            @SerializedName("volumefrom")
            val volumefrom: Double,
            @SerializedName("volumeto")
            val volumeto: Double,
            @SerializedName("close")
            val close: Double,
            @SerializedName("conversionType")
            val conversionType: String,
            @SerializedName("conversionSymbol")
            val conversionSymbol: String
        )
    }
}