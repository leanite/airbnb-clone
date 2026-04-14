package com.leanite.github.airbnb.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

val LocalSharedTransitionScope = compositionLocalOf<SharedTransitionScope?> { null }
val LocalAnimatedContentScope = compositionLocalOf<AnimatedContentScope?> { null }
val LocalAnimatedVisibilityScope = compositionLocalOf<AnimatedVisibilityScope?> { null }

// Extension para usar de forma limpa
@Composable
fun Modifier.sharedImage(key: Any, cornerRadius: Dp): Modifier {
    val sharedScope = LocalSharedTransitionScope.current ?: return this
    val animatedScope = LocalAnimatedContentScope.current ?: return this

    return with(sharedScope) {
        this@sharedImage.sharedElement(
            sharedContentState = rememberSharedContentState(key = key),
            animatedVisibilityScope = animatedScope,
            clipInOverlayDuringTransition = OverlayClip(RoundedCornerShape(cornerRadius))
        )
    }
}

@Composable
fun Modifier.sharedText(key: Any): Modifier {
    val sharedScope = LocalSharedTransitionScope.current ?: return this
    val animatedScope = LocalAnimatedContentScope.current ?: return this

    return with(sharedScope) {
        this@sharedText.sharedBounds(
            sharedContentState = rememberSharedContentState(key = key),
            animatedVisibilityScope = animatedScope,
            resizeMode = SharedTransitionScope.ResizeMode.scaleToBounds()
        )
    }
}

@Composable
fun Modifier.animateNonSharedContent(): Modifier {
    val sharedScope = LocalSharedTransitionScope.current ?: return this
    val animatedScope = LocalAnimatedVisibilityScope.current ?: return this

    return with(sharedScope) {
        with(animatedScope) {
            this@animateNonSharedContent
                .renderInSharedTransitionScopeOverlay(zIndexInOverlay = 1f)
                .animateEnterExit(
                    enter = fadeIn(),
                    exit = fadeOut()
                )
        }
    }
}