package fl0wer.app.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Precision
import fl0wer.app.presentation.entity.WoofItem
import fl0wer.ui.ext.dpRoundToPx
import fl0wer.ui.theme.WoofCardBackgroundColor

internal val CardSize = 200.dp

@Composable
internal fun WoofCard(item: WoofItem) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(CardSize)
            .clip(RoundedCornerShape(12.dp))
            .background(WoofCardBackgroundColor)
    ) {
        WoofImage(imageUrl = item.imageUrl)
        WoofId(
            text = item.idText,
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@Composable
internal fun WoofImage(imageUrl: String) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .size(CardSize.dpRoundToPx())
            .precision(Precision.EXACT)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

@OptIn(ExperimentalTextApi::class)
@Composable
internal fun WoofId(text: String, modifier: Modifier) {
    Text(
        text = text,
        fontSize = 24.sp,
        style = TextStyle.Default.copy(
            drawStyle = Stroke(
                width = 4F,
                join = StrokeJoin.Round
            )
        ),
        modifier = modifier
    )
    Text(
        text = text,
        color = MaterialTheme.colorScheme.onPrimary,
        fontSize = 24.sp,
        modifier = modifier
    )
}
