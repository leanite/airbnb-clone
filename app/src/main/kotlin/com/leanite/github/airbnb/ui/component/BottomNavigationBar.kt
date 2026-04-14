package com.leanite.github.airbnb.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leanite.github.airbnb.ui.theme.AirbnbFont
import com.leanite.github.airbnb.ui.model.BottomNavItem
import com.leanite.github.airbnb.ui.model.allBottomNavItems
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

private val AirbnbPink = Color(0xFFFF385C)
private val InactiveGray = Color(0xFF656565)
private val TopBorderGray = Color(0xFFE0E0E0)

@Composable
fun BottomNavigationBar(
    items: ImmutableList<BottomNavItem>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        // Top border line
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(TopBorderGray)
                .align(Alignment.TopCenter)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp, bottom = 4.dp)
                .windowInsetsPadding(WindowInsets.navigationBars),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items.forEachIndexed { index, item ->
                val isSelected = index == selectedIndex
                val tint = if (isSelected) AirbnbPink else InactiveGray

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = { onItemSelected(index) }
                        )
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Icon(
                        painter = painterResource(
                            id = if (isSelected) item.iconSelectedRes else item.iconRes
                        ),
                        contentDescription = item.label,
                        tint = tint,
                        modifier = Modifier.size(22.dp)
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = item.label,
                        fontFamily = AirbnbFont,
                        color = tint,
                        fontSize = 10.sp,
                        fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar(
        items = allBottomNavItems.toImmutableList(),
        selectedIndex = 0,
        onItemSelected = {},
    )
}
