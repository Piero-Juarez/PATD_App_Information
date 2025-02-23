package com.example.patd_appinformation.components

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import com.example.patd_appinformation.navigation.selectorColorDarkMode

@Composable
fun SongPageSkeleton(
    darkMode: MutableState<Boolean>,
    navController: NavHostController,
    nameTitle: String,
    keyBarColor: String,
    image: Int,
    rowOneFirtsDetail: String,
    rowOneSecondDetail: String,
    rowTwoFirtsDetail: String,
    rowTwoSecondDetail: String,
    bodyText: String,
    subTitle: String,
    songInformation: Array<Array<String>>,
    lifecycleOwner: LifecycleOwner,
    playlistCover: List<Int>,
    context: Context,
    listOfAvailableSongs: Array<String>
) {

    // Variable que almacena el índice de la canción actual
    val currentSongIndex = remember {
        mutableIntStateOf(0)
    }

    // Almacena el MediaPlayer en una variable
    val mediaPlayer by remember {
        mutableStateOf(MediaPlayer.create(context, playlistCover[currentSongIndex.intValue]))
    }

    // Variable para almacenar la canción
    val titleBottomBar = remember {
        mutableStateOf("Esperando Canción...")
    }

    // Longitud máxima permitida para el títilo de la barra
    val maxLength = 53

    // Restringe la barra hasta que el usuario presione el botón
    val checkPlayButton = remember {
        mutableStateOf(false)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            BarSongPage(
                titleSong = nameTitle,
                colorBar = selectorColorDarkMode(
                    darkMode = darkMode,
                    colorPersonalized = keyBarColor
                ),
                navController = navController,
                mediaPlayer = mediaPlayer
            ) },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = { }, // Deshabilitado por el momento
        bottomBar = { ButtonBarSongPage(
            darkMode = darkMode,
            keyBarColor = keyBarColor,
            context = context,
            currentSongIndex = currentSongIndex,
            mediaPlayer = mediaPlayer,
            listOfAvailableSongs = listOfAvailableSongs,
            checkPlayButton = checkPlayButton,
            titleBottomBar = titleBottomBar,
            maxLength = maxLength,
            playlistCover = playlistCover
        ) }
    ) { innerPadding ->
        ContentSongPageSkeleton(
            innerPadding = innerPadding,
            darkMode = darkMode,
            image = image,
            keyColor = keyBarColor,
            rowOneFirtsDetail = rowOneFirtsDetail,
            rowOneSecondDetail = rowOneSecondDetail,
            rowTwoFirtsDetail = rowTwoFirtsDetail,
            rowTwoSecondDetail = rowTwoSecondDetail,
            bodyText = bodyText,
            subTitle = subTitle,
            songInformation = songInformation,
            lifecycleOwner = lifecycleOwner,
            mediaPlayer = mediaPlayer,
            currentSongIndex = currentSongIndex,
            playlistCover = playlistCover,
            context = context,
            listOfAvailableSongs = listOfAvailableSongs,
            titleBottomBar = titleBottomBar,
            checkPlayButton = checkPlayButton,
            maxLength = maxLength
        )
    }
}

@Composable
fun ContentSongPageSkeleton(
    innerPadding: PaddingValues,
    darkMode: MutableState<Boolean>,
    image: Int,
    keyColor: String,
    rowOneFirtsDetail: String,
    rowOneSecondDetail: String,
    rowTwoFirtsDetail: String,
    rowTwoSecondDetail: String,
    bodyText: String,
    subTitle: String,
    songInformation: Array<Array<String>>,
    lifecycleOwner: LifecycleOwner,
    mediaPlayer: MediaPlayer,
    playlistCover: List<Int>,
    currentSongIndex: MutableState<Int>,
    context: Context,
    listOfAvailableSongs: Array<String>,
    titleBottomBar: MutableState<String>,
    checkPlayButton: MutableState<Boolean>,
    maxLength: Int
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
        ImageCoverPage(image = image)
        SpacerHeigth15dp()
        IconPlayCoverPage(
            darkMode = darkMode,
            keyPage = keyColor,
            mediaPlayer = mediaPlayer,
            lifecycleOwner = lifecycleOwner,
            playlistCover = playlistCover,
            currentSongIndex = currentSongIndex,
            context = context,
            titleBottomBar = titleBottomBar,
            listOfAvailableSongs = listOfAvailableSongs,
            checkPlayButton = checkPlayButton,
            maxLength = maxLength
        )
        SpacerHeigth15dp()
        DetailCoverSong(
            firtsText = rowOneFirtsDetail,
            secondText = rowOneSecondDetail,
            keyPage = keyColor,
            darkMode = darkMode
        )
        DetailCoverSong(
            firtsText = rowTwoFirtsDetail,
            secondText = rowTwoSecondDetail,
            keyPage = keyColor,
            darkMode = darkMode
        )
        SpacerHeigth20dp()
        BodyText(body = bodyText,
            darkMode = darkMode,
            keyPage = keyColor
        )
        SpacerHeigth65dp()

        Column{
            SubTitle(
                title = subTitle,
                darkMode = darkMode,
                keyPage = keyColor
            )
            SpacerHeigth20dp()
            Row {
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    SongList(
                        songInformation = songInformation,
                        keyDateSong = 0,
                        darkMode = darkMode,
                        keyPage = keyColor
                    )
                }
                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    SongList(
                        songInformation = songInformation,
                        keyDateSong = 1,
                        darkMode = darkMode,
                        keyPage = keyColor
                    )
                }
            }
        }
    }
}