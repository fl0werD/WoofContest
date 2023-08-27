package fl0wer.entity

import com.squareup.moshi.Json

data class Woof(
    @Json(name = "id")
    val id: Long,
    @Json(name = "imageUrl")
    val imageUrl: String,
)
