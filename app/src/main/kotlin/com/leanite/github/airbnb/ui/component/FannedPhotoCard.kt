package com.leanite.github.airbnb.ui.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.leanite.github.airbnb.R
import com.leanite.github.airbnb.ui.theme.FontStyle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun FannedPhotoCard(
    front: Painter,
    middle: Painter,
    back: Painter,
    baseSize: Dp,
    label: String = "Ver tudo",
    modifier: Modifier = Modifier,
) {
    // Each photo has its own Animatable for staggered bounce
    val frontProgress = remember { Animatable(0f) }
    val middleProgress = remember { Animatable(0f) }
    val backProgress = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        val bounceSpec = spring<Float>(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow,
        )
        launch {
            delay(200)
            frontProgress.animateTo(1f, bounceSpec)
        }
        launch {
            delay(350)
            middleProgress.animateTo(1f, bounceSpec)
        }
        launch {
            delay(500)
            backProgress.animateTo(1f, bounceSpec)
        }
    }

    val cardShape = RoundedCornerShape(16.dp)
    val thumbShape = RoundedCornerShape(10.dp)
    val thumbSize = baseSize/(2.7f)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .size(baseSize)
            .background(Color(0xFFF5F5F5), cardShape)
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Box {
            // Back - centered, slightly left and down
            FannedPhoto(
                painter = back,
                shape = thumbShape,
                size = thumbSize,
                targetRotation = -2f,
                targetOffsetX = (-6).dp,
                targetOffsetY = (-16).dp,
                progress = backProgress.value,
            )

            // Middle - tilted right
            FannedPhoto(
                painter = middle,
                shape = thumbShape,
                size = thumbSize,
                targetRotation = 8f,
                targetOffsetX = 16.dp,
                targetOffsetY = (-8).dp,
                progress = middleProgress.value,
            )

            // Front - tilted left (most visible, on top)
            FannedPhoto(
                painter = front,
                shape = thumbShape,
                size = thumbSize,
                targetRotation = -4f,
                targetOffsetX = (-16).dp,
                targetOffsetY = 0.dp,
                progress = frontProgress.value,
            )
        }
        Spacer(Modifier.height(8.dp))
        Text(
            text = label,
            style = FontStyle.AccommodationTitle,
        )
    }
}

@Composable
private fun FannedPhoto(
    painter: Painter,
    shape: RoundedCornerShape,
    size: Dp,
    targetRotation: Float,
    targetOffsetX: Dp,
    targetOffsetY: Dp,
    progress: Float,
) {
    val scale = progress
    val rotation = targetRotation * progress
    val offsetX = targetOffsetX * progress
    val offsetY = targetOffsetY * progress

    Box(
        modifier = Modifier
            .size(size)
            .offset(x = offsetX, y = offsetY)
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
                rotationZ = rotation
            }
            .shadow(elevation = 4.dp, shape = shape, clip = false)
            .clip(shape)
            .background(Color.White)
            .padding(2.dp),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(shape),
        )
    }
}

@Preview
@Composable
fun FannedPhotoCardPreview() {
    FannedPhotoCard(
        front = painterResource(R.drawable.apartment_leblon),
        middle = painterResource(R.drawable.apartment_copacabana),
        back = painterResource(R.drawable.apartment_maracana),
        baseSize = 168.dp
    )
}
