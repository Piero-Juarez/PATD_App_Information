package com.example.patd_appinformation.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.patd_appinformation.ui.theme.AfycsoColor
import com.example.patd_appinformation.ui.theme.BlackLigthTheme
import com.example.patd_appinformation.ui.theme.PoColor
import com.example.patd_appinformation.ui.theme.RedDarkTheme
import com.example.patd_appinformation.ui.theme.VvColor
import com.example.patd_appinformation.ui.theme.doabColor
import com.example.patd_appinformation.ui.theme.pftwColor
import com.example.patd_appinformation.ui.theme.twtltrtdColor
import com.example.patd_appinformation.views.AfycsoView
import com.example.patd_appinformation.views.DoabView
import com.example.patd_appinformation.views.HomeView
import com.example.patd_appinformation.views.PftwView
import com.example.patd_appinformation.views.PoView
import com.example.patd_appinformation.views.TwtltrtdView
import com.example.patd_appinformation.views.VvView

@Composable
fun NavManager(
    darkMode: MutableState<Boolean>
) {

    val navController = rememberNavController()

    ChangeBottomBarColor(darkMode = darkMode, navController = navController)

    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            HomeView(
                darkMode = darkMode,
                navController = navController
            )
        }

        composable("Afycso") {
            AfycsoView(
                darkMode = darkMode,
                navController = navController
            )
        }

        composable("Po") {
            PoView(
                darkMode = darkMode,
                navController = navController
            )
        }

        composable("V&v") {
            VvView(
                darkMode = darkMode,
                navController = navController
            )
        }

        composable("Twtltrtd") {
            TwtltrtdView(
                darkMode = darkMode,
                navController = navController
            )
        }

        composable("Doab") {
            DoabView(
                darkMode = darkMode,
                navController = navController
            )
        }

        composable("Pftw") {
            PftwView(
                darkMode = darkMode,
                navController = navController
            )
        }

    }
}

@Composable
fun ChangeBottomBarColor(
    darkMode: MutableState<Boolean>,
    navController: NavHostController
) {

    val activity = LocalContext.current as? Activity
    val backStackEntry by navController.currentBackStackEntryAsState()

    val barColor = when (backStackEntry?.destination?.route) {
        "Home" -> if (darkMode.value) Color(RedDarkTheme.value) else Color(BlackLigthTheme.value)
        "Afycso" -> if (darkMode.value) Color(AfycsoColor.value) else Color(BlackLigthTheme.value)
        "Po" -> if (darkMode.value) Color(PoColor.value) else Color(BlackLigthTheme.value)
        "V&v" -> if (darkMode.value) Color(VvColor.value) else Color(BlackLigthTheme.value)
        "Twtltrtd" -> if (darkMode.value) Color(twtltrtdColor.value) else Color(BlackLigthTheme.value)
        "Doab" -> if (darkMode.value) Color(doabColor.value) else Color(BlackLigthTheme.value)
        "Pftw" -> if (darkMode.value) Color(pftwColor.value) else Color(BlackLigthTheme.value)
        else -> Color.Transparent
    }

    SideEffect {
        activity?.window?.navigationBarColor = barColor.toArgb()
    }
}

@Composable
fun selectorColorDarkMode(
    darkMode: MutableState<Boolean>,
    colorPersonalized: String
) : Color {
    return if (darkMode.value) {
        when(colorPersonalized) {
            "HomeView" -> Color(RedDarkTheme.value)
            "Afycso" -> Color(AfycsoColor.value)
            "Po" -> Color(PoColor.value)
            "V&v" -> Color(VvColor.value)
            "Twtltrtd" -> Color(twtltrtdColor.value)
            "Doab" -> Color(doabColor.value)
            "Pftw" -> Color(pftwColor.value)
            else -> Color.Transparent
        }
    }
    else {
        when(colorPersonalized) {
            "HomeView" -> Color(BlackLigthTheme.value)
            "Afycso" -> Color(BlackLigthTheme.value)
            "Po" -> Color(BlackLigthTheme.value)
            "V&v" -> Color(BlackLigthTheme.value)
            "Twtltrtd" -> Color(BlackLigthTheme.value)
            "Doab" -> Color(BlackLigthTheme.value)
            "Pftw" -> Color(BlackLigthTheme.value)
            else -> Color.Transparent
        }
    }
}