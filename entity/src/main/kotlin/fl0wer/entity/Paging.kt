package fl0wer.entity

import com.squareup.moshi.Json

data class Paging(
    @Json(name = "page")
    val page: Int,
    @Json(name = "total")
    val total: Int,
)
