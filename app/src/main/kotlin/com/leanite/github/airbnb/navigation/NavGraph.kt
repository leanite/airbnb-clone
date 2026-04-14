package com.leanite.github.airbnb.navigation

import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leanite.github.airbnb.feature.detail.DetailHost
import com.leanite.github.airbnb.feature.home.HomeHost

@Composable
fun AppNav() {
    SharedTransitionLayout {
        val navController = rememberNavController()

        CompositionLocalProvider(
            LocalSharedTransitionScope provides this
        ) {
            NavHost(navController, startDestination = HomeRoute) {

                composable<HomeRoute> {
                    CompositionLocalProvider(
                        LocalAnimatedContentScope provides this
                    ) {
                        HomeHost(
                            onNavigateToDetail = { accommodation ->
                                val detailRoute = DetailRoute(
                                    id = accommodation.id,
                                    title = accommodation.place,
                                    imageRes = accommodation.imageRes
                                )
                                navController.navigate(detailRoute)
                            }
                        )
                    }
                }

                composable<DetailRoute> {
                    CompositionLocalProvider(
                        LocalAnimatedContentScope provides this,
                        LocalAnimatedVisibilityScope provides this
                    ) {
                        DetailHost(
                            onNavigateBack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}
