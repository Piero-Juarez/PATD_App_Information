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
fun PftwView(
    darkMode: MutableState<Boolean>,
    navController: NavHostController
) {

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    SongPageSkeleton(
        darkMode = darkMode,
        navController = navController,
        nameTitle = stringResource(id = R.string.pftw_title),
        keyBarColor = "Pftw",
        image = R.drawable.pray_for_the_wicked_cover,
        rowOneFirtsDetail = stringResource(id = R.string.album_spanish),
        rowOneSecondDetail = "2018",
        rowTwoFirtsDetail = "11 canciones",
        rowTwoSecondDetail = "34 minutos",
        bodyText = stringResource(id = R.string.pftw_body_text),
        subTitle = "Lista de Canciones",
        songInformation = arrayOf(
            arrayOf("(Fuck A) Silver Lining", "2:49"),
            arrayOf("Say Amen (Saturday Night)", "3:10"),
            arrayOf("Hey Look Ma, I Made It", "2:50"),
            arrayOf("High Hopes", "3:11"),
            arrayOf("Roaring 20s", "3:07"),
            arrayOf("Dancing's Not a Crime", "3:40"),
            arrayOf("One of the Drunks", "3:19"),
            arrayOf("The Overpass", "2:58"),
            arrayOf("King of the Clouds", "2:41"),
            arrayOf("Old Fashioned", "2:47"),
            arrayOf("Dying in LA", "3:50")
        ),
        lifecycleOwner = lifecycleOwner,
        playlistCover = listOf(
            R.raw.pftw_hey_look_ma_i_made_it,
            R.raw.pftw_high_hopes,
            R.raw.pftw_dancings_not_a_crime,
            R.raw.pftw_the_overpass,
            R.raw.pftw_old_fashioned
        ),
        context = context,
        listOfAvailableSongs = arrayOf(
            "Hey Look Ma, I Made It",
            "High Hopes",
            "Dancing's Not a Crime",
            "The Overpass",
            "Old Fashioned"
        )
    )

}