package com.leanite.github.airbnb.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.leanite.github.airbnb.ui.model.allTabs
import com.leanite.github.airbnb.ui.section.TabSection
import kotlinx.collections.immutable.toImmutableList

@Composable
fun TabBarShadow(
    tabBar: @Composable () -> Unit,
    shadowHeight: Dp = 10.dp,
    shadowAlpha: Float = 0.14f
) {
    Column(Modifier.wrapContentSize()) {
        tabBar()

        // sombra “descendo” a partir do topo do conteúdo (logo abaixo da TabBar)
        Box(
            Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(shadowHeight)
                .background(
                    Brush.verticalGradient(
                        colorStops = arrayOf(
                            0.0f to Color.Black.copy(alpha = shadowAlpha),
                            0.3f to Color.Black.copy(alpha = shadowAlpha * 0.4f),
                            0.6f to Color.Black.copy(alpha = shadowAlpha * 0.1f),
                            1.0f to Color.Transparent,
                        )
                    )
                )
        )
    }
}

@Preview
@Composable
fun TabBarShadowPreview() {
    TabBarShadow(
        tabBar = { TabSection(
            tabs = allTabs.toImmutableList(),
            selectedIndex = 0,
            onTabSelected = { index -> },
            modifier = Modifier
        ) }
    )
}