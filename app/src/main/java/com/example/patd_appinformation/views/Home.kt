package com.example.patd_appinformation.views

import android.media.MediaPlayer
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.patd_appinformation.R
import com.example.patd_appinformation.components.BackgroundHomeSong
import com.example.patd_appinformation.components.BodyText
import com.example.patd_appinformation.components.ImageCover
import com.example.patd_appinformation.components.LogoPATD
import com.example.patd_appinformation.components.SpacerHeigth20dp
import com.example.patd_appinformation.components.SpacerHeigth65dp
import com.example.patd_appinformation.components.SpacerHeigth5dp
import com.example.patd_appinformation.components.SpacerWidth20dp
import com.example.patd_appinformation.components.SubTitle
import com.example.patd_appinformation.components.TitleBarHome
import com.example.patd_appinformation.components.TitleCover
import com.example.patd_appinformation.navigation.selectorColorDarkMode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(
    darkMode: MutableState<Boolean>,
    navController: NavController
) {

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    BackgroundHomeSong(
        mediaPlayer = remember { MediaPlayer.create(context,R.raw.vv_background_sound) },
        lifecycleOwner = lifecycleOwner
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBarHome(name = stringResource(id = R.string.app_name)) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = selectorColorDarkMode(
                        darkMode = darkMode,
                        colorPersonalized = "HomeView"
                    )
                )
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {  }, // Deshabilitado por el momento
    ) { innerPadding ->
        ContentHomeView(
            innerPadding = innerPadding,
            darkMode = darkMode,
            navController = navController
        )
    }
}

@Composable
fun ContentHomeView(
    innerPadding: PaddingValues,
    darkMode: MutableState<Boolean>,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .wrapContentSize()
            .verticalScroll(rememberScrollState())
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Código Aquí
        Box {
            LogoPATD(
                image = R.drawable.logo_patd_removebg,
                darkMode = darkMode
            )
        }
        SpacerHeigth20dp()
        BodyText(
            body = stringResource(id = R.string.text_body_home),
            darkMode = darkMode,
            keyPage = "HomeView"
        )
        SpacerHeigth65dp()
        SubTitle(
            title = "Discografía",
            darkMode = darkMode,
            keyPage = "HomeView"
        )
        SpacerHeigth20dp()
        Row {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ImageCover(
                    image = R.drawable.a_fever_you_cant_sweat_out_cover,
                    description = "Portada: A Fever You Can't Sweat Out",
                    navController = navController,
                    keyPage = "afycso",
                )
                SpacerHeigth5dp()
                TitleCover(
                    title = "A Fever You Can't\nSweat Out",
                    ghostSpace = 0,
                    darkMode = darkMode
                )
                SpacerHeigth20dp()
                ImageCover(
                    image = R.drawable.vices_virtues_cover,
                    description = "Portada: Vices & Virtues",
                    navController = navController,
                    keyPage = "v&v"
                )
                SpacerHeigth5dp()
                TitleCover(
                    title = "Vices & Virtues",
                    ghostSpace = 20,
                    darkMode = darkMode
                )
                SpacerHeigth20dp()
                ImageCover(
                    image = R.drawable.death_of_a_bachelor_cover,
                    description = "Portada: Death Of A Bachelor",
                    navController = navController,
                    keyPage = "doab"
                )
                SpacerHeigth5dp()
                TitleCover(
                    title = "Death Of A\nBachelor",
                    ghostSpace = 0,
                    darkMode = darkMode
                )
            }
            SpacerWidth20dp()
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ImageCover(
                    image = R.drawable.pretty_odd_cover,
                    description = "Portada: Pretty. Odd.",
                    navController = navController,
                    keyPage = "po"
                )
                SpacerHeigth5dp()
                TitleCover(
                    title = "Pretty. Odd.",
                    ghostSpace = 20,
                    darkMode = darkMode
                )
                SpacerHeigth20dp()
                ImageCover(
                    image = R.drawable.too_weird_to_live_too_rare_to_die_cover,
                    description = "Portada: Too Weird to Live, Too Rare to Die!",
                    navController = navController,
                    keyPage = "twtltrtd"
                )
                SpacerHeigth5dp()
                TitleCover(
                    title = "Too Weird to Live,\nToo Rare to Die!",
                    ghostSpace = 0,
                    darkMode = darkMode
                )
                SpacerHeigth20dp()
                ImageCover(
                    image = R.drawable.pray_for_the_wicked_cover,
                    description = "Portada: Pray For The Wicked",
                    navController = navController,
                    keyPage = "pftw"
                )
                SpacerHeigth5dp()
                TitleCover(
                    title = "Pray For The\nWicked",
                    ghostSpace = 0,
                    darkMode = darkMode
                )
            }
        }
//        SpacerHeigth65dp()
//        SubTitle(
//            title = "Integrantes",
//            darkMode = darkMode,
//            keyPage = "HomeView"
//        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeView() {

    val darkMode = remember { mutableStateOf(false) }
    val navController = rememberNavController()
    val innerPadding = PaddingValues()

    ContentHomeView(
        innerPadding = innerPadding,
        darkMode = darkMode,
        navController = navController
    )

}