package com.leanite.github.airbnb.ui.section

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.leanite.github.airbnb.ui.model.allTabs
import com.leanite.github.airbnb.ui.model.Tab
import com.leanite.github.airbnb.ui.model.TextMeasure
import com.leanite.github.airbnb.ui.item.TabItem
import com.leanite.github.airbnb.ui.theme.BlackishText
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun TabSection(
    tabs: ImmutableList<Tab>,
    onTabSelected: (Int) -> Unit,
    selectedIndex: Int = 0,
    collapseProgress: Float = 0f,  // 0 = expandido, 1 = colapsado
    modifier: Modifier = Modifier
) {
    // Guarda posição X e largura de cada texto de Tab
    val textCoordinates = remember { mutableStateMapOf<Int, TextMeasure>() }
    val currentText = textCoordinates[selectedIndex]

    val indicatorOffset by animateDpAsState(
        targetValue = currentText?.offsetX ?: 0.dp,
        animationSpec = tween(250, easing = FastOutSlowInEasing),
        label = "indicatorOffset"
    )
    val indicatorWidth by animateDpAsState(
        targetValue = currentText?.width ?: 0.dp,
        animationSpec = tween(250, easing = FastOutSlowInEasing),
        label = "indicatorWidth"
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                listOf(
                    Color.Transparent,
                    Color.White
                )
            ))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            tabs.forEachIndexed { index, tab ->
                val offset = if (index == 1) 4.dp else 0.dp
                TabItem(
                    tab = tab,
                    selected = index == selectedIndex,
                    onTabClicked = { onTabSelected(index) },
                    onTextPositioned = { offset, width ->
                        textCoordinates[index] = TextMeasure(offset, width)
                    },
                    collapseProgress = collapseProgress,
                    modifier = Modifier.offset(x = (-16).dp),
                    offset = offset
                )
            }
        }

        if (currentText != null) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .offset(x = indicatorOffset)
                    .width(indicatorWidth)
                    .height(3.dp)
                    .background(
                        color = BlackishText,
                        shape = RoundedCornerShape(topStart = 3.dp, topEnd = 3.dp)
                    )
            )
        }
    }
}

@Preview
@Composable
fun TabSectionPreview(){
    TabSection(
        tabs = allTabs.toImmutableList(),
        onTabSelected = {

        }
    )
}