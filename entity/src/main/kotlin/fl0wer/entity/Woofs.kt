package fl0wer.entity

import com.squareup.moshi.Json

data class Woofs(
    @Json(name = "items")
    val items: List<Woof>,
    @field:Json(name = "meta")
    val paging: Paging,
)
