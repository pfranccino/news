package cl.pfranccino.news.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color


object NewsColors {
    val Background = Color(0xFF121212)
    val PrimaryText = Color(0xFFFFFFFF)
    val SecondaryText = Color(0xFFB3B3B3)
    val AccentColor1 = Color(0xFFBB86FC)
    val AccentColor2 = Color(0xFF03DAC6)
    val SentimentPositive = Color(0xFF69F0AE)
    val SentimentNeutral = Color(0xFFFFDE03)
    val SentimentNegative = Color(0xFFFF5252)
    val IconsAndButtons = Color(0xFFFFFFFF)
    val DividerLine = Color(0xFF272727)
    val Comment = Color(0xFF1E1E1E)
    val InputField = Color(0xFF1F1F1F)
}

val DarkNewsColorScheme = darkColorScheme(
    primary = NewsColors.AccentColor1,
    secondary = NewsColors.AccentColor2,
    tertiary = NewsColors.SentimentPositive,
    background = NewsColors.Background,
    surface = NewsColors.Background,
    error = NewsColors.SentimentNegative,
    onPrimary = NewsColors.Background,
    onSecondary = NewsColors.Background,
    onTertiary = NewsColors.Background,
    onBackground = NewsColors.PrimaryText,
    onSurface = NewsColors.PrimaryText,
    onError = NewsColors.PrimaryText
)

val LightNewsColorScheme = lightColorScheme(
    primary = NewsColors.AccentColor1,
    secondary = NewsColors.AccentColor2,
    tertiary = NewsColors.SentimentPositive,
    background = NewsColors.PrimaryText,
    surface = NewsColors.PrimaryText,
    error = NewsColors.SentimentNegative,
    onPrimary = NewsColors.PrimaryText,
    onSecondary = NewsColors.PrimaryText,
    onTertiary = NewsColors.PrimaryText,
    onBackground = NewsColors.Background,
    onSurface = NewsColors.Background,
    onError = NewsColors.PrimaryText
)