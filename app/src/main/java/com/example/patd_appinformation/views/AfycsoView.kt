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
fun AfycsoView(
    darkMode: MutableState<Boolean>,
    navController: NavHostController
) {

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    SongPageSkeleton(
        darkMode = darkMode,
        navController = navController,
        nameTitle = stringResource(id = R.string.afycso_title),
        keyBarColor = "Afycso",
        image = R.drawable.a_fever_you_cant_sweat_out_cover,
        rowOneFirtsDetail = "Albúm",
        rowOneSecondDetail = "2005",
        rowTwoFirtsDetail = "13 canciones",
        rowTwoSecondDetail = "39 minutos",
        bodyText = stringResource(id = R.string.afycso_body_text),
        subTitle = "Lista de Canciones",
        songInformation = arrayOf(
            arrayOf("Introduction", "0:37"),
            arrayOf("The Only Difference Between Martyrdom and Suicide Is Press Coverage", "2:54"),
            arrayOf("London Beckoned Songs About Money Written by Machines", "3:23"),
            arrayOf("Nails for Breakfast, Tacks for Snacks", "3:23"),
            arrayOf("Camisado", "3:11"),
            arrayOf("Time to Dance", "3:22"),
            arrayOf("Lying Is the Most Fun a Girl Can Have Without Taking Her Clothes Off", "3:20"),
            arrayOf("Intermission", "2:35"),
            arrayOf("But It's Better If You Do", "3:25"),
            arrayOf("I Write Sins Not Tragedies", "3:06"),
            arrayOf("I Constantly Thank God for Esteban", "3:30"),
            arrayOf("There's a Good Reason These Tables Are Numbered Honey, You Just Haven't Thought of It Yet", "3:16"),
            arrayOf("Build God, Then We'll Talk", "3:40")
        ),
        playlistCover = listOf(
            R.raw.afycso_london_beckoned_songs_about_money_written_by_machines,
            R.raw.afycso_camisado,
            R.raw.afycso_time_to_dance,
            R.raw.afycso_i_write_sins_not_tragedies,
            R.raw.afycso_build_god_then_well_talk
        ),
        lifecycleOwner = lifecycleOwner,
        context = context,
        listOfAvailableSongs = arrayOf(
            "London Beckoned Songs About Money Written by Machines",
            "Camisado",
            "Time to Dance",
            "I Write Sins Not Tragedies",
            "Build God, Then We'll Talk"
        )
    )
}