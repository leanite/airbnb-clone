package com.leanite.github.airbnb.ui.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.leanite.github.airbnb.ui.model.allTabs
import com.leanite.github.airbnb.ui.model.Tab
import com.leanite.github.airbnb.ui.component.NewBadge
import com.leanite.github.airbnb.ui.theme.FontStyle

@Composable
fun TabItem(
    tab: Tab,
    selected: Boolean,
    onTabClicked: (Tab) -> Unit,
    onTextPositioned: (offset: Dp, width: Dp) -> Unit,
    collapseProgress: Float,
    modifier: Modifier = Modifier,
    offset: Dp = 0.dp
) {
    val screenDensity = LocalDensity.current
    // Interpolações baseadas no progress
    val iconAlpha = 1f - collapseProgress
    val iconScale = lerp(1f, 0.5f, collapseProgress)
    val iconHeight = lerpDp(32.dp, 0.dp, collapseProgress)
    val badgeOffset = lerpDp(24.dp, 0.dp, collapseProgress)

    val textStyle = if (selected) {
        FontStyle.TabItemSelected
    } else {
        FontStyle.TabItemNotSelected
    }

    Box(modifier = Modifier) {
        Column(
            modifier = modifier
                .padding(bottom = 8.dp)
                .clickable { onTabClicked(tab) },
            horizontalAlignment = CenterHorizontally
        ) {
            Image(
                painter = painterResource(tab.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .height(iconHeight)
                    .wrapContentWidth()
                    .graphicsLayer {
                        alpha = iconAlpha
                        scaleX = iconScale
                        scaleY = iconScale
                    }
                    .offset(y = offset)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = tab.title,
                style = textStyle,
                modifier = Modifier
                    .onGloballyPositioned { coordinates ->
                        with(screenDensity) {
                            onTextPositioned(
                                coordinates.positionInRoot().x.toDp(),
                                coordinates.size.width.toDp()
                            )
                        }
                    }
            )
        }

        if (tab.isNew) {
            NewBadge(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(x = badgeOffset),
                collapseProgress = collapseProgress
            )
        }
    }
}

private fun lerpDp(start: Dp, stop: Dp, fraction: Float): Dp {
    return start + (stop - start) * fraction
}

@Preview
@Composable
fun TabItemPreview() {
    TabItem(
        tab = allTabs[1],
        selected = true,
        onTabClicked = {},
        collapseProgress = 0f,
        onTextPositioned = { dp: Dp, dp1: Dp -> }
    )
}