package cl.pfranccino.news.ui.home

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cl.pfranccino.news.utils.Dimens

@Composable
fun ItemNewsScreenSkeleton() {
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f)
    )

    val transition = rememberInfiniteTransition(label = "")
    val translateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = ""
    )

    Column(
        modifier = Modifier.padding(
            start = Dimens.spacing16,
            end = Dimens.spacing16,
            bottom = Dimens.spacing8,
            top = Dimens.spacing8
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(Dimens.radiusMedium))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = shimmerColors,
                        startX = translateAnim.value - 1000f,
                        endX = translateAnim.value
                    )
                )
        )

        Spacer(modifier = Modifier.height(Dimens.spacing8))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = shimmerColors,
                        startX = translateAnim.value - 1000f,
                        endX = translateAnim.value
                    )
                )
        )

        Spacer(modifier = Modifier.height(Dimens.spacing4))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = shimmerColors,
                        startX = translateAnim.value - 1000f,
                        endX = translateAnim.value
                    )
                )
        )


    }
}


@Composable
@Preview
fun ItemNewsScreenSkeletonPreview() {
    ItemNewsScreenSkeleton()
}