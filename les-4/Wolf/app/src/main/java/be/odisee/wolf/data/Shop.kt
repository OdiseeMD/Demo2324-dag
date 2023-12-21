package com.example.shops.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import be.odisee.wolf.R

data class Shop(
    @DrawableRes val imageResourceId: Int,
    @StringRes val titleResourceId: Int,
    @StringRes val descriptionResourceId: Int,
    @StringRes val handleResourceId: Int? = null
)

val shops = listOf(
    Shop(R.drawable.bar, R.string.bar, R.string.bar_description, R.string.bar_handle),
    Shop(
        R.drawable.bollyfood,
        R.string.bollyfood_stories,
        R.string.bollyfood_stories_description,
        R.string.bollyfood_stories_handle
    ),
    Shop(
        R.drawable.dierendonck,
        R.string.dierendonck,
        R.string.dierendonck_description,
        R.string.dierendonck_handle
    ),
    Shop(R.drawable.dims, R.string.dims, R.string.dims_description, R.string.dims_handle),
    Shop(R.drawable.eaters, R.string.eaters, R.string.eaters_description, R.string.eaters_handle),
    Shop(
        R.drawable.hanoi_station,
        R.string.hanoi_station,
        R.string.hanoi_station_description,
        R.string.hanoi_station_handle
    ),
    Shop(R.drawable.idea, R.string.idea, R.string.idea_description, R.string.idea_handle),
    Shop(
        R.drawable.la_piola_pizza,
        R.string.la_piola_pizza,
        R.string.la_piola_pizza_description,
        R.string.la_piola_pizza_handle
    ),
    Shop(R.drawable.mare, R.string.mare, R.string.mare_description),
    Shop(R.drawable.mix, R.string.mix, R.string.mix_description),
    Shop(
        R.drawable.mordimi,
        R.string.mordimi,
        R.string.mordimi_description,
        R.string.mordimi_handle
    ),
    Shop(
        R.drawable.my_tannour,
        R.string.my_tannour,
        R.string.my_tannour_description,
        R.string.my_tannour_handle
    ),
    Shop(
        R.drawable.poke_club,
        R.string.poke_club,
        R.string.poke_club_description,
        R.string.poke_club_handle
    ),
    Shop(
        R.drawable.socal_tacos,
        R.string.socal_tacos,
        R.string.socal_tacos_description,
        R.string.socal_tacos_handle
    ),
    Shop(
        R.drawable.super_filles,
        R.string.super_filles,
        R.string.super_filles_description,
        R.string.super_filles_handle
    ),
    Shop(
        R.drawable.ten_grams,
        R.string.ten_grams,
        R.string.ten_grams_description,
        R.string.ten_grams_handle
    ),
    Shop(
        R.drawable.toukoul,
        R.string.toukoul,
        R.string.toukoul_description,
        R.string.toukoul_handle
    ),
    Shop(
        R.drawable.vincent_denis,
        R.string.vincent_denis,
        R.string.vincent_denis_description,
        R.string.vincent_denis_handle
    ),
)
