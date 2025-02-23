package com.example.patd_appinformation.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.patd_appinformation.components.SongPageSkeleton
import com.example.patd_appinformation.R

@Composable
fun TwtltrtdView(
    darkMode: MutableState<Boolean>,
    navController: NavHostController
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    
    SongPageSkeleton(
        darkMode = darkMode,
        navController = navController,
        nameTitle = stringResource(id = R.string.twtltrtd_title),
        keyBarColor = "Twtltrtd",
        image = R.drawable.too_weird_to_live_too_rare_to_die_cover,
        rowOneFirtsDetail = "Albúm",
        rowOneSecondDetail = "2013",
        rowTwoFirtsDetail = "10 canciones",
        rowTwoSecondDetail = "32 minutos",
        bodyText = stringResource(id = R.string.twtltrtd_body_text),
        subTitle = "Lista de Canciones",
        songInformation = arrayOf(
            arrayOf("This Is Gospel", "3:08"),
            arrayOf("Miss Jackson", "3:13"),
            arrayOf("Vegas Lights", "3:10"),
            arrayOf("Girl That You Love", "3:10"),
            arrayOf("Nicotine", "3:07"),
            arrayOf("Girls / Girls / Boys", "3:27"),
            arrayOf("Casual Affair", "3:18"),
            arrayOf("Far Too Young to Die", "3:18"),
            arrayOf("Collar Full", "3:19"),
            arrayOf("The End of All Things", "3:32")
        ),
        lifecycleOwner = lifecycleOwner,
        playlistCover = listOf(
            R.raw.twtltrtd_this_is_gospel,
            R.raw.twtltrtd_vegas_lights,
            R.raw.twtltrtd_nicotine,
            R.raw.twtltrtd_girls_girls_boys,
            R.raw.twtltrtd_collar_full
        ),
        context = context,
        listOfAvailableSongs = arrayOf(
            "This Is Gospel",
            "Vegas Lights",
            "Nicotine",
            "Girls / Girls / Boys",
            "Collar Full"
        )
    )
    
}