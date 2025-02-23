package com.example.patd_appinformation.components

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

@Composable
fun BackgroundHomeSong(
    mediaPlayer: MediaPlayer,
    lifecycleOwner: LifecycleOwner
) {

    // Reproduce la música al montar el Composable y gestiona el ciclo de vida
    DisposableEffect(lifecycleOwner) {
        mediaPlayer.isLooping = true

        // Observador del ciclo de vida
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_RESUME -> {
                    try {
                        if (!mediaPlayer.isPlaying) {
                            mediaPlayer.start()
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                Lifecycle.Event.ON_PAUSE -> {
                    try {
                        if (mediaPlayer.isPlaying) {
                            mediaPlayer.pause()
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                Lifecycle.Event.ON_DESTROY -> {
                    try {
                        mediaPlayer.stop()
                        mediaPlayer.release()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                else -> {}
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
            try {
                mediaPlayer.stop()
                mediaPlayer.release()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

fun playBackgroundMusic(
    mediaPlayer: MediaPlayer,
    lifecycleOwner: LifecycleOwner,
    playlistCover: List<Int>,
    currentSongIndex: MutableState<Int>,
    context: Context,
    listOfAvailableSongs: Array<String>,
    titleBottomBar: MutableState<String>,
    maxLength: Int
) {

    mediaPlayer.start()
    mediaPlayer.isLooping = false

    // Listener que detecta cuando la canción termina
    mediaPlayer.setOnCompletionListener {

        currentSongIndex.value = (currentSongIndex.value + 1) % playlistCover.size // Avanza al siguiente índice

        val inspectText = listOfAvailableSongs[currentSongIndex.value]

        if (inspectText.length > maxLength) {
            titleBottomBar.value = inspectText.take(maxLength) + "..."
        } else {
            titleBottomBar.value = inspectText
        }

        mediaPlayer.reset()
        mediaPlayer.setDataSource(context, Uri.parse("android.resource://${context.packageName}/${playlistCover[currentSongIndex.value]}"))
        mediaPlayer.prepare()
        mediaPlayer.start()
    }

    val observer = LifecycleEventObserver { _, event ->
        when (event) {
            Lifecycle.Event.ON_DESTROY -> {
                mediaPlayer.stop()
                mediaPlayer.release()
            }
            else -> {}
        }
    }

    // Observa los eventos del ciclo de vida
    lifecycleOwner.lifecycle.addObserver(observer)
}

fun pauseBackgroundMusic(
    mediaPlayer: MediaPlayer
) {
    try {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun startBackgroundMusic(
    mediaPlayer: MediaPlayer
) {
    try {
        if (!mediaPlayer.isPlaying) {
            mediaPlayer.start()
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun nextOrPreviousSong(
    context: Context,
    currentSongIndex: MutableState<Int>,
    mediaPlayer: MediaPlayer,
    playlistCover: List<Int>
) {
    mediaPlayer.reset()
    mediaPlayer.setDataSource(
        context,
        Uri.parse("android.resource://${context.packageName}/${playlistCover[currentSongIndex.value]}")
    )
    mediaPlayer.prepare()
    mediaPlayer.start()
}