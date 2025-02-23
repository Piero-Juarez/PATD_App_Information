package com.example.patd_appinformation.components

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.patd_appinformation.navigation.selectorColorDarkMode
import com.example.patd_appinformation.ui.theme.WhiteDarkTheme

@Composable
fun TitleBarHome(name: String) {
    Text(
        text = name,
        fontSize = 23.sp,
        color = Color.White,
        fontStyle = FontStyle.Italic
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarSongPage(
    titleSong: String,
    colorBar: Color,
    navController: NavController,
    mediaPlayer: MediaPlayer
) {
    TopAppBar(
        title = { TitleBarHome(name = titleSong) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorBar
        ),
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White,
                )
            }
        }
    )
}

@Composable
fun ButtonBarSongPage(
    darkMode: MutableState<Boolean>,
    keyBarColor: String,
    context: Context,
    currentSongIndex: MutableState<Int>,
    mediaPlayer: MediaPlayer,
    listOfAvailableSongs: Array<String>,
    checkPlayButton: MutableState<Boolean>,
    titleBottomBar: MutableState<String>,
    maxLength: Int,
    playlistCover: List<Int>,
    sharePOP: PlayOrPause = viewModel()
) {

    BottomAppBar(
        modifier = Modifier
            .wrapContentSize()
            .clip(
                RoundedCornerShape(
                    topStart = 35.dp,
                    topEnd = 35.dp
                )
            ),
        containerColor = selectorColorDarkMode(
            darkMode = darkMode,
            colorPersonalized = keyBarColor
        )
    ) {

        Column(
            modifier = Modifier
                .weight(0.8f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clickable {

                        if (checkPlayButton.value) {
                            currentSongIndex.value = if (currentSongIndex.value > 0) {
                                currentSongIndex.value - 1
                            } else {
                                listOfAvailableSongs.size - 1
                            }

                            titleBottomBar.value = truncateText(
                                listOfAvailableSongs = listOfAvailableSongs,
                                currentSongIndex = currentSongIndex,
                                maxLength = maxLength
                            )

                            // Actualizar y reiniciar el mediaPlayer
                            nextOrPreviousSong(
                                context = context,
                                currentSongIndex = currentSongIndex,
                                mediaPlayer = mediaPlayer,
                                playlistCover = playlistCover
                            )

                        }

                    },
                tint = Color(WhiteDarkTheme.value)
            )
        }
        Column(
            modifier = Modifier
                .weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = titleBottomBar.value,
                textAlign = TextAlign.Center,
                color = Color(WhiteDarkTheme.value),
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier = Modifier
                .weight(0.8f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clickable {

                        if (checkPlayButton.value) {
                            currentSongIndex.value =
                                (currentSongIndex.value + 1) % listOfAvailableSongs.size

                            titleBottomBar.value = truncateText(
                                listOfAvailableSongs = listOfAvailableSongs,
                                currentSongIndex = currentSongIndex,
                                maxLength = maxLength
                            )

                            sharePOP.playOrPause = false

                            // Actualizar y reiniciar el mediaPlayer
                            nextOrPreviousSong(
                                context = context,
                                currentSongIndex = currentSongIndex,
                                mediaPlayer = mediaPlayer,
                                playlistCover = playlistCover
                            )
                        }

                    },
                tint = Color(WhiteDarkTheme.value)
            )
        }
    }
}

fun truncateText(
    listOfAvailableSongs: Array<String>,
    currentSongIndex: MutableState<Int>,
    maxLength: Int
): String {

    val inspectText = listOfAvailableSongs[currentSongIndex.value]

    return if (inspectText.length > maxLength) {
        inspectText.take(maxLength) + "..."
    } else {
        inspectText
    }

}