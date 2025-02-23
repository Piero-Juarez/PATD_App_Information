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
fun PoView(
    darkMode: MutableState<Boolean>,
    navController: NavHostController
) {

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    SongPageSkeleton(
        darkMode = darkMode,
        navController = navController,
        nameTitle = stringResource(id = R.string.po_title),
        keyBarColor = "Po",
        image = R.drawable.pretty_odd_cover,
        rowOneFirtsDetail = "Albúm",
        rowOneSecondDetail = "2008",
        rowTwoFirtsDetail = "16 canciones",
        rowTwoSecondDetail = "51 minutos",
        bodyText = stringResource(id = R.string.po_body_text),
        subTitle = "Lista de Canciones",
        songInformation = arrayOf(
            arrayOf("We're So Starving", "1:21"),
            arrayOf("Nine in the Afternoon", "3:11"),
            arrayOf("She's a Handsome Woman", "3:12"),
            arrayOf("Do You Know What I'm Seeing?", "4:14"),
            arrayOf("That Green Gentleman (Things Have Changed)", "3:15"),
            arrayOf("I Have Friends in Holy Spaces", "1:56"),
            arrayOf("Northern Downpour", "4:07"),
            arrayOf("When the Day Met the Night", "4:53"),
            arrayOf("Pas de Cheval", "2:39"),
            arrayOf("The Piano Knows Something I Don't Know", "3:43"),
            arrayOf("Behind the Sea", "3:33"),
            arrayOf("Folkin' Around", "1:55"),
            arrayOf("She Had the World", "3:47"),
            arrayOf("From a Mountain in the Middle of the Cabins", "3:02"),
            arrayOf("Mad as Rabbits", "3:48")
        ),
        playlistCover = listOf(
            R.raw.po_do_you_know_what_im_seeing,
            R.raw.po_the_piano_knows_something_i_dont_know,
            R.raw.po_behind_the_sea,
            R.raw.po_she_had_the_world
        ),
        lifecycleOwner = lifecycleOwner,
        context = context,
        listOfAvailableSongs = arrayOf(
            "Do You Know What I'm Seeing?",
            "The Piano Knows Something I Don't Know",
            "Behind the Sea",
            "She Had the World"
        )
    )
}