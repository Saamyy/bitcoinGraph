package n26assignment.workstation.samy.base.Model

data class MarketPriceApiResponse(
    val status: String,
    val name: String,
    val unit: String,
    val period: String,
    val description: String,
    val values: List<MarketPrice>
)