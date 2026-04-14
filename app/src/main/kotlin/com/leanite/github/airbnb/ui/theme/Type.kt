package com.leanite.github.airbnb.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.leanite.github.airbnb.R

val AirbnbFont = FontFamily(
    Font(R.font.airbnb_cereal_light, FontWeight.Light),
    Font(R.font.airbnb_cereal_book, FontWeight.Normal),
    Font(R.font.airbnb_cereal_medium, FontWeight.Medium),
    Font(R.font.airbnb_cereal_bold, FontWeight.SemiBold),
    Font(R.font.airbnb_cereal_extrabold, FontWeight.Bold),
    Font(R.font.airbnb_cereal_black, FontWeight.Black),
)

private val BaseStyle = TextStyle(fontFamily = AirbnbFont)

object FontStyle {
    val TabItemSelected = BaseStyle.copy(
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        color = BlackishText
    )
    val TabItemNotSelected = BaseStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = ThinGrayText
    )

    val TripBannerTitle = BaseStyle.copy(
        fontWeight = FontWeight.SemiBold,
        fontSize = 17.sp,
        color = BlackishText,
    )

    val TripInfo = BaseStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        color = ThinGrayText
    )

    val Header = BaseStyle.copy(
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        color = BlackishText,
    )

    val AccommodationTitle = BaseStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = BlackishText
    )

    val AccommodationSubTitle = BaseStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        color = ThinGrayText
    )

    val PlaceTitle = BaseStyle.copy(
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        color = BlackishText
    )

    val PlaceSubtitle = BaseStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = ThinGrayText
    )

    val DetailTitle = BaseStyle.copy(
        fontWeight = FontWeight.SemiBold,
        fontSize = 27.sp,
        color = BlackishText,
    )

    val DetailSubtitle = BaseStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        color = ThinGrayText,
    )

    val DetailInfo = BaseStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = ThinGrayText,
    )

    val DetailRatingNumber = BaseStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        color = BlackishText,
    )

    val DetailRatingLabel = BaseStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        lineHeight = 15.sp,
        color = BlackishText,
    )

    val DetailHostName = BaseStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        color = BlackishText,
    )

    val DetailHostInfo = BaseStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = ThinGrayText,
    )

    val DetailHighlightTitle = BaseStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = BlackishText,
    )

    val DetailHighlightSubtitle = BaseStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = ThinGrayText,
    )

    val DetailBottomBarPrice = BaseStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        color = BlackishText,
    )

    val DetailBottomBarButton = BaseStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        color = Color.White,
    )
}

val Typography = Typography(
    displayLarge = BaseStyle,
    displayMedium = BaseStyle,
    displaySmall = BaseStyle,
    headlineLarge = BaseStyle,
    headlineMedium = BaseStyle,
    headlineSmall = BaseStyle,
    titleLarge = BaseStyle,
    titleMedium = BaseStyle,
    titleSmall = BaseStyle,
    bodyLarge = BaseStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = BaseStyle,
    bodySmall = BaseStyle,
    labelLarge = BaseStyle,
    labelMedium = BaseStyle,
    labelSmall = BaseStyle,
)