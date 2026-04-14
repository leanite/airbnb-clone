package com.leanite.github.airbnb.ui.model

import com.leanite.github.airbnb.R

sealed class Tab (
    val id: Int,
    val imageRes: Int,
    val title: String,
    val isNew: Boolean = false
) {
    object Houses : Tab(id = 0, imageRes = R.drawable.tab_house, title = "Acomodações", isNew = false)
    object Experiences : Tab(id = 1, imageRes = R.drawable.tab_balloon, title = "Experiências", isNew = true)
    object Services : Tab(id = 2, imageRes = R.drawable.tab_ring, title = "Serviços", isNew = true)
}

val allTabs = listOf(Tab.Houses, Tab.Experiences, Tab.Services)