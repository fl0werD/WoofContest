package fl0wer.app.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import fl0wer.app.domain.Model
import fl0wer.app.domain.State
import fl0wer.app.presentation.shimmer.WoofsListShimmer

@Composable
internal fun WoofsScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val collectedState by Model.observeState().collectAsState()
        when (val state = collectedState) {
            is State.Loading -> WoofsListShimmer()
            is State.Data -> WoofsList(
                items = state.woofs,
                totalItems = state.paging.total,
                requestNextPage = { Model.woofs() }
            )
        }
    }
}
