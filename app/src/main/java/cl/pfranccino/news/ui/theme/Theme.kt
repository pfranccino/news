package cl.pfranccino.news.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable


@Composable
fun NewsTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkNewsColorScheme
    } else {
        LightNewsColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = NewsTypography,
        content = content
    )
}