package com.example.patd_appinformation.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavHostController
import com.example.patd_appinformation.R
import com.example.patd_appinformation.components.SongPageSkeleton

@Composable
fun DoabView(
    darkMode: MutableState<Boolean>,
    navController: NavHostController
) {
    
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    SongPageSkeleton(
        darkMode = darkMode,
        navController = navController,
        nameTitle = stringResource(id = R.string.doab_title),
        keyBarColor = "Doab",
        image = R.drawable.death_of_a_bachelor_cover,
        rowOneFirtsDetail = stringResource(id = R.string.album_spanish),
        rowOneSecondDetail = "2016",
        rowTwoFirtsDetail = "11 canciones",
        rowTwoSecondDetail = "32 minutos",
        bodyText = stringResource(id = R.string.doab_body_text),
        subTitle = "Lista de Canciones",
        songInformation = arrayOf(
            arrayOf("Victorious", "2:59"),
            arrayOf("Don't Threaten Me With a Good Time", "3:34"),
            arrayOf("Hallelujah", "3:01"),
            arrayOf("Emperor's New Clothes", "2:39"),
            arrayOf("Death of a Bachelor", "3:24"),
            arrayOf("Crazy = Genius", "3:19"),
            arrayOf("LA Devotee", "3:17"),
            arrayOf("Golden Days", "4:15"),
            arrayOf("The Good, the Bad and the Dirty", "2:52"),
            arrayOf("House of Memories", "3:29"),
            arrayOf("Impossible Year", "3:23")
        ),
        lifecycleOwner = lifecycleOwner,
        playlistCover = listOf(
            R.raw.doab_victorious,
            R.raw.doab_emperors_new_clothes,
            R.raw.doab_la_devotee,
            R.raw.doab_golden_days,
            R.raw.doab_house_of_memories
        ),
        context = context,
        listOfAvailableSongs = arrayOf(
            "Victorious",
            "Emperor's New Clothes",
            "LA Devotee",
            "Golden Days",
            "House of Memories"
        )
    )
    
}