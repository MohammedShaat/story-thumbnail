package com.example.story_thumbnail

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Creates a composable that displays a thumbnail for a story. This will contain a content
 * (image) surrounded with stroke/dashes corresponding to the number of stories.
 *
 * @param count Total number of stories.
 * @param seen Number of seen stories.
 * @param content Content to display, usually an image.
 * @param onClick Will be called when user clicks on the element.
 * @param seenColor Dash color of seen stories.
 * @param unSeenColor Dash color of unseen stories.
 * @param width Width of dashes.
 * @param spacing Space between dashes.
 */
@Composable
fun StoryThumbnail(
    count: Int,
    seen: Int,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    seenColor: Color = Color.Green,
    unSeenColor: Color = Color.Gray,
    width: Dp = 3.dp,
    spacing: Dp = 2.dp,
) {

    var minSize by remember { mutableStateOf(0f) }
    val sweepAngle by remember { mutableStateOf((360 / count).toFloat()) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .onSizeChanged {
                minSize = minOf(it.width, it.height).toFloat()
            }
            .clickable { onClick() },
    ) {
        // Image
        Box(
            modifier = Modifier
                .size((minSize * .29f).dp)
                .clip(CircleShape)
        ) {
            content()
        }

        // Stroke
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding((minSize * .02).dp),
        ) {
            repeat(count) { idx ->
                drawArc(
                    color = if (idx < seen) seenColor else unSeenColor,
                    startAngle = (idx * sweepAngle - 90) + spacing.toPx(),
                    sweepAngle = sweepAngle - spacing.toPx() * 2,
                    useCenter = false,
                    style = Stroke(width = width.toPx(), cap = StrokeCap.Round)
                )
            }
        }
    }
}