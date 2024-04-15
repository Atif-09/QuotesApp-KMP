package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuotesDataClassItem(
    @SerialName("a")
    val a: String,
    @SerialName("c")
    val c: String,
    @SerialName("h")
    val h: String,
    @SerialName("q")
    val q: String
)