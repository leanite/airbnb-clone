<div align="center">

# Airbnb Clone
### Pixel-perfect clone of [Airbnb](https://www.airbnb.com/) — built with Kotlin & Jetpack Compose

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![Min SDK](https://img.shields.io/badge/minSdk-24-brightgreen?style=for-the-badge)

<table>
  <tr>
    <td align="center"><img src="https://leanite.github.io/assets/airbnb/airbnb_original.gif"  width="250"/><br/>
    <b>Original</b></td>
    <td align="center"><img src="https://leanite.github.io/assets/airbnb/airbnb_clone.gif" width="250"/><br/>
    <b>Clone</b></td>
  </tr>
</table>

[<img src="https://cdn.simpleicons.org/android/3DDC84" width="18" style="vertical-align: middle;"/> Download APK](https://github.com/leanite/airbnb-clone/releases) &nbsp;•&nbsp; [📸 Screen Comparison](#screen-comparison) &nbsp;•&nbsp; [🎯 Visual Features](#visual-features)

</div>

---

## About

A pixel-perfect clone of **Airbnb**, the world's leading accommodation marketplace, built as a portfolio project focused on **visual fidelity and Jetpack Compose proficiency**. The goal was to replicate the real user experience — layout, animations, transitions, and micro-interactions without using the original app's source code as reference.

The architecture follows MVVM + MVI + Clean Architecture with local data sources, ready for real API integration.

---

## Screen Comparison

Each row shows the original screen alongside the cloned version.

### Category Tabs

<table>
  <tr>
    <td align="center"><img src="https://leanite.github.io/assets/airbnb/tabs_original.png"  width="400"/><br/>
    <b>Original</b></td>
    <td align="center"><img src="https://leanite.github.io/assets/airbnb/tabs_clone.png" width="400"/><br/>
    <b>Clone</b></td>
  </tr>
</table>

### Sticky Tab Bar Collapse

<table>
  <tr>
    <td align="center"><img src="https://leanite.github.io/assets/airbnb/collapse_original.gif"  width="400"/><br/>
    <b>Original</b></td>
    <td align="center"><img src="https://leanite.github.io/assets/airbnb/collapse_clone.gif" width="400"/><br/>
    <b>Clone</b></td>
  </tr>
</table>

### See All Button Animation

<table>
  <tr>
    <td align="center"><img src="https://leanite.github.io/assets/airbnb/see_all_anim_original.gif"  width="400"/><br/>
    <b>Original</b></td>
    <td align="center"><img src="https://leanite.github.io/assets/airbnb/see_all_anim_clone.gif" width="400"/><br/>
    <b>Clone</b></td>
  </tr>
</table>

### Current Trip Banner

<table>
  <tr>
    <td align="center"><img src="https://leanite.github.io/assets/airbnb/trip_banner_original.png"  width="400"/><br/>
    <b>Original</b></td>
    <td align="center"><img src="https://leanite.github.io/assets/airbnb/trip_banner_clone.png" width="400"/><br/>
    <b>Clone</b></td>
  </tr>
</table>

### Recently Seen Section

<table>
  <tr>
    <td align="center"><img src="https://leanite.github.io/assets/airbnb/last_seen_original.png"  width="400"/><br/>
    <b>Original</b></td>
    <td align="center"><img src="https://leanite.github.io/assets/airbnb/last_seen_clone.png" width="400"/><br/>
    <b>Clone</b></td>
  </tr>
</table>

### Recommendation Section

<table>
  <tr>
    <td align="center"><img src="https://leanite.github.io/assets/airbnb/recommendation_original.png"  width="400"/><br/>
    <b>Original</b></td>
    <td align="center"><img src="https://leanite.github.io/assets/airbnb/recommendation_clone.png" width="400"/><br/>
    <b>Clone</b></td>
  </tr>
</table>

### Places to Visit

<table>
  <tr>
    <td align="center"><img src="https://leanite.github.io/assets/airbnb/places_original.png"  width="400"/><br/>
    <b>Original</b></td>
    <td align="center"><img src="https://leanite.github.io/assets/airbnb/places_clone.png" width="400"/><br/>
    <b>Clone</b></td>
  </tr>
</table>

### Accommodation Detail

<table>
  <tr>
    <td align="center"><img src="https://leanite.github.io/assets/airbnb/detail_original.png"  width="400"/><br/>
    <b>Original</b></td>
    <td align="center"><img src="https://leanite.github.io/assets/airbnb/detail_clone.png" width="400"/><br/>
    <b>Clone</b></td>
  </tr>
</table>

---

## Visual Features

A breakdown of what was implemented and what was left out of scope:

| Element | Status | Notes |
|---------|--------|-------|
| Home screen layout | ✅ Implemented | Full scrollable home with gradient background |
| Typography & color palette | ✅ Implemented | Custom font and brand colors |
| Search bar | ✅ Implemented | Rounded surface with search icon |
| Category tabs | ✅ Implemented | Horizontal tabs with animated underline indicator |
| Sticky tab bar on scroll | ✅ Implemented | Collapses into compact bar with icon/badge animations |
| "New" badge on tabs | ✅ Implemented | Custom shape with gradient, scale animation on collapse |
| Recently seen accommodations | ✅ Implemented | Horizontal list with highlight cards |
| Recommendation section | ✅ Implemented | Horizontal list with accommodation type labels |
| Visit other places section | ✅ Implemented | Custom vertical list with custom images |
| Current trip banner | ✅ Implemented | Stacked photos with rotation, trip info and date range |
| Accommodation cards with ratings | ✅ Implemented | Rating badges, superhost badges, price info |
| Superhost badge | ✅ Implemented | Semi-transparent overlay badge |
| Animated bottom navigation | ✅ Implemented | Selected/unselected icon states with Airbnb pink highlight |
| Accommodation detail screen | ✅ Implemented | Hero image, info row, rating section, host info, bottom bar |
| Shared element transitions | ✅ Implemented | Image transitions between Home and Detail |
| Fanned photo card animation | ✅ Implemented | Staggered spring animations with scale, offset and rotation |
| Real API integration | ❌ Out of scope | Mock data — architecture ready for swap |
| Additional screens | ❌ Out of scope | Cloning the entire app is beyond the current scope |
| Image carousel in detail | ❌ Out of scope | Single image hero instead of pager |
| Map integration | ❌ Out of scope | Focus is on UI fidelity, not map features |

> The goal was not to replicate Airbnb's business logic, but to demonstrate mastery of complex UI with Jetpack Compose.

---

## Animations & Interactions

**Sticky Tab Bar Collapse**
As the user scrolls past the category tabs, icons scale down, "New" badges shrink, and the bar compresses into a compact version. Built with scroll state observation, `animateFloatAsState`, and lerp-based interpolation.

**Fanned Photo Card**
At the end of horizontal lists, three photos animate in with staggered spring physics — each card scales up, rotates, and offsets with `DampingRatioMediumBouncy` springs and progressive delays (200ms, 350ms, 500ms).

**Shared Element Transitions**
Tapping an accommodation card triggers a smooth shared element transition — the image morphs with `RoundedCornerShape` clipping via `OverlayClip`, while text uses `sharedBounds` with `ScaleToBounds` resize mode. Non-shared content fades in/out through the overlay.

**Bottom Navigation**
Each tab switches between filled and outlined icon variants with the Airbnb pink accent color on the selected state.

---

## Tech Stack

Built with modern Android development tools and libraries, prioritizing stability and production-readiness.

**Core:**

- **[Kotlin 2.0+](https://kotlinlang.org/)** — Modern, expressive programming language
  - **[Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)** — Asynchronous programming
  - **[KSP](https://kotlinlang.org/docs/ksp-overview.html)** — Kotlin Symbol Processing
  - **[Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization)** — Type-safe JSON serialization

**Android Jetpack:**

- **[Compose](https://developer.android.com/jetpack/compose)** — Declarative UI framework
- **[Material Design 3](https://m3.material.io/)** — Latest design system
- **[Navigation Compose](https://developer.android.com/jetpack/compose/navigation)** — Type-safe navigation with shared element transitions
- **[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)** — UI state management
- **[Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle)** — Lifecycle-aware components

**Dependency Injection:**

- **[Hilt](https://dagger.dev/hilt/)** — Dependency injection framework built on Dagger

**UI & Media:**

- **[Coil](https://coil-kt.github.io/coil/)** — Kotlin-first image loading for Compose
- **[Kotlinx Collections Immutable](https://github.com/Kotlin/kotlinx.collections.immutable)** — Immutable collections for Compose optimization
- **[Material Icons](https://developer.android.com/reference/kotlin/androidx/compose/material/icons/package-summary)** — Icon set for UI components

**Build:**

- **[Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)** — Type-safe build scripts
- **[Version Catalogs](https://docs.gradle.org/current/userguide/platforms.html#sub:version-catalog)** — Centralized dependency management

---

## Architecture

MVVM + MVI + Clean Architecture, aligned with [Google's official architecture guidance](https://developer.android.com/topic/architecture). Data is mocked locally to keep the focus on visual fidelity — the layered architecture is ready for real API integration.

| Layer | Package | Responsibility |
|-------|---------|----------------|
| **Core** | `core/` | AppResult, AppError |
| **Domain** | `domain/` | Models, repository interfaces, use cases |
| **Data** | `data/` | Repository implementations, local data sources, mock data, DI |
| **Feature** | `feature/` | Host/Screen/Effects pattern, Contract, ViewModel |
| **UI** | `ui/` | Composable components, sections, items, theme |
| **Navigation** | `navigation/` | Routes, NavGraph, shared transition providers |

The Feature layer follows the **Host / Screen / Effects** pattern with MVI-style unidirectional data flow: **UI → Action → ViewModel → State → UI**

```
src/main/kotlin/com/leanite/github/airbnb/
├── core/
│   └── result/             # AppResult, AppError
├── domain/
│   ├── model/              # Accommodation, Place, Trip, DateRange, HomeData
│   ├── repository/         # Repository interfaces
│   └── usecase/            # GetHomeDataUseCase, GetAccommodationByIdUseCase
├── data/
│   ├── datasource/         # Local data sources
│   ├── repository/         # Implementations
│   ├── mock/               # Mock data (accommodations, places, trips)
│   └── di/                 # Hilt DataModule
├── feature/
│   ├── home/               # Host, Screen, ViewModel, Contract, Effects
│   └── detail/             # Host, Screen, ViewModel, Contract, Effects
├── navigation/
│   ├── Routes.kt           # Type-safe route definitions
│   ├── NavGraph.kt         # Navigation graph with shared transitions
│   └── SharedTransitionProvider.kt  # Shared element modifiers
└── ui/
    ├── theme/              # Airbnb Cereal font, brand colors, typography
    ├── component/          # Reusable composables (12 components)
    ├── section/            # Screen sections (4 sections)
    ├── item/               # List item cards (3 item types)
    └── model/              # Tab, BottomNavItem, TextMeasure
```

---

## Getting Started

```bash
git clone https://github.com/leanite/airbnb-clone.git
```

Open in **Android Studio** → Run.

No API key or additional setup required.

> Rather not build it yourself? [Download the APK directly](https://github.com/leanite/airbnb-clone/releases).

---

## What I Learned Replicating This App

- **Shared element transitions** — Coordinating image and text transitions between screens required composing `SharedTransitionLayout`, custom `OverlayClip` with corner radius, and careful management of animated visibility scopes for non-shared content.
- **Sticky tab bar with animated collapse** — Smoothly scaling icons, shrinking badges, and compressing the tab bar on scroll needed precise lerp-based interpolation tied to scroll state, avoiding jarring visual jumps.
- **Fanned photo card with spring physics** — Getting three stacked photos to fan out with staggered spring animations meant fine-tuning `DampingRatioMediumBouncy` specs and progressive delays to feel natural and playful.
- **Stacked photo effect** — Layering three rotated, offset photos with shadows for the trip banner required careful z-ordering and `graphicsLayer` transformations.

---

## Author

**Leandro Carneiro** — Android Developer

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/lcleite/)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/leanite)

---

## Legal Disclaimer

This project is strictly educational and for portfolio purposes. It has no commercial intent and is not affiliated with, endorsed by, or sponsored by Airbnb, Inc. All trademarks, logos, and visual elements belong to their respective owners.

---

<div align="center">
If this project was useful to you, consider leaving a ⭐
</div>
