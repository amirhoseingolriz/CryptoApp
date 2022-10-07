package ir.golriz.amirhosein.cryptoapp.model.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class Coins(

    @SerializedName("Data")
    val `data`: List<Data>
) {
    @Parcelize
    data class Data(
        @SerializedName("CoinInfo")
        val coinInfo: CoinInfo,
        @SerializedName("DISPLAY")
        val dISPLAY: DISPLAY
    ) : Parcelable {
        @Parcelize
        data class CoinInfo(
            @SerializedName("Id")
            val id: String,
            @SerializedName("Name")
            val name: String,
            @SerializedName("FullName")
            val fullName: String,
            @SerializedName("Internal")
            val `internal`: String,
            @SerializedName("ImageUrl")
            val imageUrl: String,
            @SerializedName("Url")
            val url: String,
            @SerializedName("Algorithm")
            val algorithm: String,
            @SerializedName("ProofType")
            val proofType: String,
            @SerializedName("NetHashesPerSecond")
            val netHashesPerSecond: Double,
            @SerializedName("BlockNumber")
            val blockNumber: Int,
            @SerializedName("BlockTime")
            val blockTime: Double,
            @SerializedName("BlockReward")
            val blockReward: Double,
            @SerializedName("AssetLaunchDate")
            val assetLaunchDate: String,
            @SerializedName("MaxSupply")
            val maxSupply: Double,
            @SerializedName("Type")
            val type: Int,
            @SerializedName("DocumentType")
            val documentType: String
        ) : Parcelable

        @Parcelize
        data class DISPLAY(
            @SerializedName("USD")
            val uSD: USD
        ) : Parcelable {
            @Parcelize
            data class USD(
                @SerializedName("FROMSYMBOL")
                val fROMSYMBOL: String,
                @SerializedName("TOSYMBOL")
                val tOSYMBOL: String,
                @SerializedName("MARKET")
                val mARKET: String,
                @SerializedName("PRICE")
                val pRICE: String,
                @SerializedName("LASTUPDATE")
                val lASTUPDATE: String,
                @SerializedName("LASTVOLUME")
                val lASTVOLUME: String,
                @SerializedName("LASTVOLUMETO")
                val lASTVOLUMETO: String,
                @SerializedName("LASTTRADEID")
                val lASTTRADEID: String,
                @SerializedName("VOLUMEDAY")
                val vOLUMEDAY: String,
                @SerializedName("VOLUMEDAYTO")
                val vOLUMEDAYTO: String,
                @SerializedName("VOLUME24HOUR")
                val vOLUME24HOUR: String,
                @SerializedName("VOLUME24HOURTO")
                val vOLUME24HOURTO: String,
                @SerializedName("OPENDAY")
                val oPENDAY: String,
                @SerializedName("HIGHDAY")
                val hIGHDAY: String,
                @SerializedName("LOWDAY")
                val lOWDAY: String,
                @SerializedName("OPEN24HOUR")
                val oPEN24HOUR: String,
                @SerializedName("HIGH24HOUR")
                val hIGH24HOUR: String,
                @SerializedName("LOW24HOUR")
                val lOW24HOUR: String,
                @SerializedName("LASTMARKET")
                val lASTMARKET: String,
                @SerializedName("VOLUMEHOUR")
                val vOLUMEHOUR: String,
                @SerializedName("VOLUMEHOURTO")
                val vOLUMEHOURTO: String,
                @SerializedName("OPENHOUR")
                val oPENHOUR: String,
                @SerializedName("HIGHHOUR")
                val hIGHHOUR: String,
                @SerializedName("LOWHOUR")
                val lOWHOUR: String,
                @SerializedName("TOPTIERVOLUME24HOUR")
                val tOPTIERVOLUME24HOUR: String,
                @SerializedName("TOPTIERVOLUME24HOURTO")
                val tOPTIERVOLUME24HOURTO: String,
                @SerializedName("CHANGE24HOUR")
                val cHANGE24HOUR: String,
                @SerializedName("CHANGEPCT24HOUR")
                val cHANGEPCT24HOUR: String,
                @SerializedName("CHANGEDAY")
                val cHANGEDAY: String,
                @SerializedName("CHANGEPCTDAY")
                val cHANGEPCTDAY: String,
                @SerializedName("CHANGEHOUR")
                val cHANGEHOUR: String,
                @SerializedName("CHANGEPCTHOUR")
                val cHANGEPCTHOUR: String,
                @SerializedName("CONVERSIONTYPE")
                val cONVERSIONTYPE: String,
                @SerializedName("CONVERSIONSYMBOL")
                val cONVERSIONSYMBOL: String,
                @SerializedName("SUPPLY")
                val sUPPLY: String,
                @SerializedName("MKTCAP")
                val mKTCAP: String,
                @SerializedName("MKTCAPPENALTY")
                val mKTCAPPENALTY: String,
                @SerializedName("CIRCULATINGSUPPLY")
                val cIRCULATINGSUPPLY: String,
                @SerializedName("CIRCULATINGSUPPLYMKTCAP")
                val cIRCULATINGSUPPLYMKTCAP: String,
                @SerializedName("TOTALVOLUME24H")
                val tOTALVOLUME24H: String,
                @SerializedName("TOTALVOLUME24HTO")
                val tOTALVOLUME24HTO: String,
                @SerializedName("TOTALTOPTIERVOLUME24H")
                val tOTALTOPTIERVOLUME24H: String,
                @SerializedName("TOTALTOPTIERVOLUME24HTO")
                val tOTALTOPTIERVOLUME24HTO: String,
                @SerializedName("IMAGEURL")
                val iMAGEURL: String
            ) : Parcelable
        }
    }
}
