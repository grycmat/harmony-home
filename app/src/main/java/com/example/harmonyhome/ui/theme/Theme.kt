package com.example.harmonyhome.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme =  darkColorScheme(
    primary = Color(0xFF3498db), // Blue Dark Blue
    secondary = Color(0xFFe74c3c), // Red // Dark Red
    background = Color(0xFF2c3e50), // Dark Blue
    surface = Color(0xFF34495e), // Dark Gray
    onPrimary = Color(0xFFFFFFFF), // White
    onSecondary = Color(0xFFFFFFFF), // White
    onBackground = Color(0xFFFFFFFF), // White
    onSurface = Color(0xFFFFFFFF), // White
    error = Color(0xFFe74c3c), // Red
    onError = Color(0xFFFFFFFF) // White
)

private val LightColorScheme =  lightColorScheme(
    primary = Color(0xFF3498db), // Blue/ Dark Blue
    secondary = Color(0xFFe74c3c), // Red Dark Red
    background = Color(0xFFecf0f1), // Light Gray
    surface = Color(0xFFecf0f1), // Light Gray
    onPrimary = Color(0xFFFFFFFF), // White
    onSecondary = Color(0xFFFFFFFF), // White
    onBackground = Color(0xFF2c3e50), // Dark Blue
    onSurface = Color(0xFF2c3e50), // Dark Blue
    error = Color(0xFFe74c3c), // Red
    onError = Color(0xFFFFFFFF) // White
)

@Composable
fun HarmonyHomeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}