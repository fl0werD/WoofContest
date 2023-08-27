package fl0wer.app.presentation.entity

import fl0wer.entity.Woof

data class WoofItem(
    val id: Long,
    val idText: String,
    val imageUrl: String,
)

fun List<Woof>.toItems() = map { it.toItem() }

fun Woof.toItem() = WoofItem(
    id = id,
    idText = id.toString(),
    imageUrl = imageUrl,
)
