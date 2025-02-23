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
fun VvView(
    darkMode: MutableState<Boolean>,
    navController: NavHostController
) {

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    SongPageSkeleton(
        darkMode = darkMode,
        navController = navController,
        nameTitle = stringResource(id = R.string.vv_title),
        keyBarColor = "V&v",
        image = R.drawable.vices_virtues_cover,
        rowOneFirtsDetail = "Albúm",
        rowOneSecondDetail = "2011",
        rowTwoFirtsDetail = "10 canciones",
        rowTwoSecondDetail = "37 minutos",
        bodyText = stringResource(id = R.string.vv_body_text),
        subTitle = "Lista de Canciones",
        songInformation = arrayOf(
            arrayOf("The Ballad of Mona Lisa", "3:47"),
            arrayOf("Let's Kill Tonight", "3:33"),
            arrayOf("Hurricane", "4:25"),
            arrayOf("Memories", "3:26"),
            arrayOf("Trade Mistakes", "3:36"),
            arrayOf("Ready to Go (Get Me Out of My Mind)", "3:37"),
            arrayOf("Always", "2:34"),
            arrayOf("The Calendar", "4:43"),
            arrayOf("Sarah Smiles", "3:33"),
            arrayOf("Nearly Witches (Ever Since We Met...)", "4:16")
        ),
        playlistCover = listOf(
            R.raw.vv_lets_kill_tonight,
            R.raw.vv_hurricane,
            R.raw.vv_sarah_smiles,
            R.raw.vv_nearly_witches
        ),
        lifecycleOwner = lifecycleOwner,
        context = context,
        listOfAvailableSongs = arrayOf(
            "Let's Kill Tonight",
            "Hurricane",
            "Sarah Smiles",
            "Nearly Witches (Ever Since We Met...)"
        )
    )
}