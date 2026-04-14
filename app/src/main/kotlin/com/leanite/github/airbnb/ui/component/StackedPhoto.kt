package com.leanite.github.airbnb.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
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

@Composable
fun StackedPhoto(
    front: Painter,
    middle: Painter,
    back: Painter,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier.size(72.dp),
        contentAlignment = Alignment.Center
    ) {
        val shape = RoundedCornerShape(12.dp)

        // Back
        FramedPhoto(
            painter = back,
            shape = shape,
            frame = 2.dp,
            offset = Pair(-(4).dp, 2.dp),
            modifier = Modifier.size(100.dp),
            rotationZ = -16f
        )
        //Midle
        FramedPhoto(
            painter = middle,
            shape = shape,
            frame = 2.dp,
            offset = Pair(6.dp, -(2).dp),
            modifier = Modifier.size(100.dp),
            rotationZ = 4f
        )
        // Front
        FramedPhoto(
            painter = front,
            shape = shape,
            frame = 2.dp,
            offset = Pair(0.dp,0.dp),
            modifier = Modifier.size(100.dp),
            rotationZ = 0f
        )
    }
}

@Composable
private fun FramedPhoto(
    painter: Painter,
    shape: RoundedCornerShape,
    frame: Dp,
    offset: Pair<Dp,Dp>,
    modifier: Modifier = Modifier,
    rotationZ: Float = 0f
) {
    Box(
        modifier = modifier
            .graphicsLayer { this.rotationZ = rotationZ }
            .offset(x = offset.first, y = offset.second)
            .shadow(elevation = 10.dp, shape = shape, clip = false)
            .clip(shape)
            .background(Color.White)
            .padding(frame),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(shape)
        )
    }
}

@Preview
@Composable
fun StackedPhotoPreview() {
    StackedPhoto(
        front = painterResource(R.drawable.apartment_leblon),
        middle = painterResource(R.drawable.apartment_copacabana),
        back = painterResource(R.drawable.apartment_maracana),
    )
}