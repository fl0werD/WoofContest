package fl0wer.app.domain

import fl0wer.entity.Paging
import fl0wer.app.presentation.entity.WoofItem

internal sealed class State {

    data object Loading : State()

    data class Data(
        val woofs: List<WoofItem> = emptyList(),
        val paging: Paging,
    ) : State()
}
