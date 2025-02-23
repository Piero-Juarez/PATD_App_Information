package com.example.patd_appinformation.components

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Pause
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.patd_appinformation.navigation.selectorColorDarkMode
import com.example.patd_appinformation.ui.theme.WhiteDarkTheme

@Composable
fun LogoPATD(
    image: Int,
    darkMode: MutableState<Boolean>
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        colorFilter = ColorFilter.tint(
            selectorColorDarkMode(
            darkMode = darkMode,
            colorPersonalized = "HomeView"
        )),
        modifier = Modifier
            .clickable { darkMode.value = !darkMode.value }
    )
}

@Composable
fun ImageCover(
    image: Int,
    description: String,
    navController: NavController,
    keyPage: String,
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = description,
        modifier = Modifier
            .size(160.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                when (keyPage) {
                    "afycso" -> navController.navigate("Afycso") {
                        anim {
                            enter = 0
                            exit = 0
                            popEnter = 0
                            popExit = 0
                        }
                    }

                    "po" -> navController.navigate("Po") {
                        anim {
                            enter = 0
                            exit = 0
                            popEnter = 0
                            popExit = 0
                        }
                    }

                    "v&v" -> navController.navigate("V&v") {
                        anim {
                            enter = 0
                            exit = 0
                            popEnter = 0
                            popExit = 0
                        }
                    }

                    "twtltrtd" -> navController.navigate("Twtltrtd") {
                        anim {
                            enter = 0
                            exit = 0
                            popEnter = 0
                        }
                    }

                    "doab" -> navController.navigate("Doab") {
                        anim {
                            enter = 0
                            exit = 0
                            popEnter = 0
                        }
                    }

                    "pftw" -> navController.navigate("Pftw") {
                        anim {
                            enter = 0
                            exit = 0
                            popEnter = 0
                        }
                    }
                }
            }
    )
}

@Composable
fun TitleCover(
    title: String,
    ghostSpace: Int,
    darkMode: MutableState<Boolean>
) {
    val espace = ""
    val titleGhost = espace.padEnd(ghostSpace, ' ')
    Text(
        text =
        if (ghostSpace == 0) { title }
        else { title + "\n" + titleGhost },
        textAlign = TextAlign.Center,
        color = selectorColorDarkMode(
            darkMode = darkMode,
            colorPersonalized = "HomeView"
        )
    )
}

@Composable
fun SubTitle(
    title: String,
    darkMode: MutableState<Boolean>,
    keyPage: String
) {
    Text(
        text = title,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = selectorColorDarkMode(
            darkMode = darkMode,
            colorPersonalized = keyPage
        ),
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Composable
fun BodyText(
    body: String,
    darkMode: MutableState<Boolean>,
    keyPage: String
) {
    Text(
        text = body,
        color = selectorColorDarkMode(
            darkMode = darkMode,
            colorPersonalized = keyPage
        ),
        textAlign = TextAlign.Center
    )
}

@Composable
fun ImageCoverPage(
    image: Int
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        modifier = Modifier
            .size(260.dp)
            .clip(RoundedCornerShape(15.dp))
    )
}

class PlayOrPause : ViewModel() {
    var playOrPause by mutableStateOf(true)
}

@Composable
fun IconPlayCoverPage(
    darkMode: MutableState<Boolean>,
    keyPage: String,
    mediaPlayer: MediaPlayer,
    lifecycleOwner: LifecycleOwner,
    playlistCover: List<Int>,
    currentSongIndex: MutableState<Int>,
    context: Context,
    titleBottomBar: MutableState<String>,
    listOfAvailableSongs: Array<String>,
    checkPlayButton: MutableState<Boolean>,
    maxLength: Int,
    sharePOP: PlayOrPause = viewModel()
) {

    var once by remember {
        mutableStateOf(true)
    }

    var accesoUnico by remember {
        mutableStateOf(false)
    }

    Icon(
        imageVector = if (sharePOP.playOrPause) { Icons.Rounded.PlayArrow} else { Icons.Rounded.Pause },
        contentDescription = null,
        tint = Color(WhiteDarkTheme.value),
        modifier = Modifier
            .size(80.dp)
            .clip(RoundedCornerShape(50.dp))
            .clickable {

                if (once) {
                    playBackgroundMusic(
                        mediaPlayer = mediaPlayer,
                        lifecycleOwner = lifecycleOwner,
                        playlistCover = playlistCover,
                        currentSongIndex = currentSongIndex,
                        context = context,
                        listOfAvailableSongs = listOfAvailableSongs,
                        titleBottomBar = titleBottomBar,
                        maxLength = maxLength
                    )
                }

                if (accesoUnico) {
                    if (sharePOP.playOrPause) {
                        startBackgroundMusic(
                            mediaPlayer = mediaPlayer
                        )
                    } else {
                        pauseBackgroundMusic(
                            mediaPlayer = mediaPlayer
                        )
                    }
                }

                if (once) {
                    val inspectText = listOfAvailableSongs[0]
                    if (inspectText.length > maxLength) {
                        titleBottomBar.value = inspectText.take(maxLength) + "..."
                    } else {
                        titleBottomBar.value = inspectText
                    }
                }

                once = false

                accesoUnico = true

                sharePOP.playOrPause = !sharePOP.playOrPause

                checkPlayButton.value = true
            }
            .background(
                selectorColorDarkMode(
                    darkMode = darkMode,
                    colorPersonalized = keyPage
                )
            )
    )
}

@Composable
fun DetailCoverSong(
    firtsText: String,
    secondText: String,
    keyPage: String,
    darkMode: MutableState<Boolean>
) {
    Text(
        text = "$firtsText • $secondText",
        color = selectorColorDarkMode(
            darkMode = darkMode,
            colorPersonalized = keyPage
        ),
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
}

@Composable
fun SongList(
    songInformation: Array<Array<String>>,
    keyDateSong: Int,
    darkMode: MutableState<Boolean>,
    keyPage: String
) {

    if (keyDateSong == 0) {
        for (subArray in songInformation) {
            val elementoFijo = subArray[0]
            TextSongList(
                darkMode = darkMode,
                keyPage = keyPage,
                text = elementoFijo
            )
            SpacerHeigth15dp()
        }
    } else {
        for (subArray in songInformation) {
            val elementoFijo = subArray[1]
            TextSongList(
                darkMode = darkMode,
                keyPage = keyPage,
                text = elementoFijo
            )
            SpacerHeigth15dp()
        }
    }
}

@Composable
fun TextSongList(
    darkMode: MutableState<Boolean>,
    keyPage: String,
    text: String,
    maxLength: Int = 25 // Longitud máxima permitida
) {

    val truncatedText = if (text.length > maxLength) {
        text.take(maxLength) + "..."
    } else {
        text
    }

    Text(
        text = truncatedText,
        color = selectorColorDarkMode(
            darkMode = darkMode,
            colorPersonalized = keyPage
        )
    )
}

@Composable
fun SpacerWidth20dp() {
    Spacer(modifier = Modifier.width(20.dp))
}

@Composable
fun SpacerHeigth20dp() {
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun SpacerHeigth5dp() {
    Spacer(modifier = Modifier.height(5.dp))
}

@Composable
fun SpacerHeigth15dp() {
    Spacer(modifier = Modifier.height(15.dp))
}

@Composable
fun SpacerHeigth65dp() {
    Spacer(modifier = Modifier.height(65.dp))
}