package n26assignment.workstation.samy.base.model

import com.google.gson.annotations.SerializedName

data class MarketPrice(

    @SerializedName("x")
    val timeSpan: Long,

    @SerializedName("y")
    val value: Float
)