package com.leanite.github.airbnb.feature.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leanite.github.airbnb.data.mock.allAccommodations
import com.leanite.github.airbnb.domain.model.Accommodation
import com.leanite.github.airbnb.navigation.animateNonSharedContent
import com.leanite.github.airbnb.navigation.sharedImage
import com.leanite.github.airbnb.navigation.sharedText
import com.leanite.github.airbnb.ui.theme.AirbnbFont
import com.leanite.github.airbnb.ui.theme.AirbnbPink
import com.leanite.github.airbnb.ui.theme.BlackishText
import com.leanite.github.airbnb.ui.theme.FontStyle
import com.leanite.github.airbnb.ui.theme.LightSeparator
import com.leanite.github.airbnb.ui.theme.ThinGrayText
import androidx.compose.ui.text.font.FontWeight
import com.leanite.github.airbnb.R

@Composable
fun DetailScreen(
    uiState: DetailUiState,
    onAction: (DetailAction) -> Unit = {},
) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val totalHeight = maxHeight
        val imageHeight: Dp = totalHeight * 0.43f
        val sheetOverlap = 24.dp
        val sheetHeight = totalHeight * 0.57f + sheetOverlap
        val accommodation = uiState.accommodation

        Image(
            painter = painterResource(uiState.imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(imageHeight)
                .sharedImage(key = "image-${uiState.imageRes}", cornerRadius = 0.dp)
        )

        // Top bar overlay
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsPadding(WindowInsets.statusBars)
                .padding(horizontal = 8.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(onClick = { onAction(DetailAction.BackClicked) }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    tint = BlackishText,
                    modifier = Modifier
                        .size(32.dp)
                        .background(Color.White, CircleShape)
                        .padding(6.dp)
                )
            }
            Row {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Compartilhar",
                        tint = BlackishText,
                        modifier = Modifier
                            .size(32.dp)
                            .background(Color.White, CircleShape)
                            .padding(6.dp)
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favoritar",
                        tint = BlackishText,
                        modifier = Modifier
                            .size(32.dp)
                            .background(Color.White, CircleShape)
                            .padding(6.dp)
                    )
                }
            }
        }

        // Bottom sheet content
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(sheetHeight)
                .align(Alignment.BottomCenter)
                .animateNonSharedContent()
                .background(
                    Color.White,
                    RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 16.dp)
            ) {
                if (accommodation != null) {
                    // Title
                    Text(
                        textAlign = TextAlign.Center,
                        text = accommodation.shortDescription,
                        style = FontStyle.DetailTitle,
                        lineHeight = 28.sp,
                        letterSpacing = (-1).sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 32.dp, start = 24.dp, end = 24.dp),
                    )

                    // Subtitle
                    Text(
                        text = "Espaço inteiro: ${accommodation.type.lowercase()} em ${accommodation.neighborhood}",
                        style = FontStyle.DetailSubtitle,
                        textAlign = TextAlign.Center,
                        letterSpacing = (-0.5).sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, start = 24.dp, end = 24.dp),
                    )

                    // Accommodation info
                    Text(
                        text = "${accommodation.guests} hóspedes  ·  ${accommodation.rooms} quarto  ·  ${accommodation.beds} camas  ·  ${accommodation.bathrooms} banheiro",
                        style = FontStyle.DetailInfo,
                        textAlign = TextAlign.Center,
                        letterSpacing = (-0.5).sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 2.dp, start = 24.dp, end = 24.dp)
                    )

                    Spacer(Modifier.height(20.dp))

                    RatingRow(accommodation)

                    Spacer(Modifier.height(20.dp))
                    HorizontalDivider(
                        color = LightSeparator,
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
                    )

                    HostInfoSection(accommodation)
                    Spacer(Modifier.height(16.dp))

                    HorizontalDivider(
                        color = LightSeparator,
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
                    )

                    HighlightSection()
                }
            }

            // Bottom bar
            if (accommodation != null) {
                DetailBottomBar(accommodation)
            }
        }
    }
}

@Composable
private fun RatingRow(accommodation: Accommodation) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // Rating column
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(0.25f),
        ) {
            Text(
                text = accommodation.rating.toString().replace(".", ","),
                style = FontStyle.DetailRatingNumber,
            )
            Row(modifier = Modifier.offset(y = (-2).dp),
                verticalAlignment = Alignment.CenterVertically) {
                repeat(5) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = BlackishText,
                        modifier = Modifier.size(10.dp)
                    )
                }
            }
        }

        // Vertical divider
        Box(
            modifier = Modifier
                .width(1.dp)
                .fillMaxHeight()
                .padding(vertical = 4.dp)
                .background(LightSeparator)
        )

        // Superhost column
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(0.5f)
                .fillMaxWidth(),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    contentDescription = null,
                    painter = painterResource(R.drawable.icon_golden_crown),
                    modifier = Modifier.height(32.dp)
                )
                Text(
                    text = "Preferido\ndos hóspedes",
                    style = FontStyle.DetailRatingLabel,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Image(
                    contentDescription = null,
                    painter = painterResource(R.drawable.icon_golden_crown),
                    modifier = Modifier
                        .height(32.dp)
                        .scale(scaleX = -1f, scaleY = 1f)
                )
            }
        }

        // Vertical divider
        Box(
            modifier = Modifier
                .width(1.dp)
                .fillMaxHeight()
                .padding(vertical = 4.dp)
                .background(LightSeparator)
        )

        // Reviews column
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(0.25f),
        ) {
            Text(
                text = "${accommodation.reviews}",
                style = FontStyle.DetailRatingNumber,
            )
            Text(
                text = "avaliações",
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                color = BlackishText,
                modifier = Modifier.offset(y = (-2).dp)
            )
        }
    }
}

@Composable
private fun HostInfoSection(accommodation: Accommodation) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        verticalAlignment = Alignment.Top,
    ) {
        // Avatar
        val avatarHeight = 48.dp
        Box(
            modifier = Modifier.size(48.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(avatarHeight)
                    .clip(CircleShape)
                    .background(BlackishText),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = accommodation.hostName.firstOrNull()?.uppercase() ?: "A",
                    fontFamily = AirbnbFont,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = Color.White,
                )
            }
            if (accommodation.isSuperHost) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd),
                ) {
                    Image(
                        contentDescription = null,
                        painter = painterResource(R.drawable.icon_exclamation),
                        modifier = Modifier
                            .size(20.dp)
                            .offset(x = 4.dp, y = 4.dp)
                    )
                }
            }
        }

        Spacer(Modifier.width(12.dp))

        Column(
            modifier = Modifier.height(avatarHeight).padding(vertical = 2.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "Anfitriã(o): ${accommodation.hostName}",
                style = FontStyle.DetailHostName,
            )
            Text(
                text = buildString {
                    if (accommodation.isSuperHost) append("Superhost · ")
                    append("hospeda há ${accommodation.hostMonths} meses")
                },
                style = FontStyle.DetailHostInfo,
            )
        }
    }
}

@Composable
private fun HighlightSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
    ) {
        Column(
            modifier = Modifier.size(58.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(4.dp))
            Image(
                contentDescription = null,
                painter = painterResource(R.drawable.icon_trophy),
                modifier = Modifier.size(24.dp)
            )
        }
        Column {
            Text(
                text = "No top 5% das acomodações",
                style = FontStyle.DetailHighlightTitle,
            )
            Text(
                text = "Esta acomodação é muito bem classificada pelas avaliações e comentários",
                style = FontStyle.DetailHighlightSubtitle,
            )
        }
    }
}

@Composable
private fun DetailBottomBar(accommodation: Accommodation) {
    HorizontalDivider(color = LightSeparator)
    Spacer(Modifier.height(8.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .windowInsetsPadding(WindowInsets.navigationBars)
            .padding(horizontal = 24.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier.weight(0.45f)
        ) {
            Text(
                text = "Adicione datas\npara ver os preços",
                style = FontStyle.DetailBottomBarPrice,
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = BlackishText,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(Modifier.width(2.dp))
                Text(
                    text = accommodation.rating.toString().replace(".", ","),
                    style = FontStyle.DetailBottomBarPrice,
                )
            }
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = AirbnbPink),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.height(68.dp).weight(0.55f),
        ) {
            Text(
                text = "Conferir\ndisponibilidade",
                style = FontStyle.DetailBottomBarButton,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    val accommodation = allAccommodations[0]
    DetailScreen(
        uiState = DetailUiState(
            id = accommodation.id,
            imageRes = accommodation.imageRes,
            accommodation = accommodation,
        ),
    )
}
