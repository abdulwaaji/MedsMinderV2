package com.waajid.medsminder.ui

sealed class Screens(val route: String){

    object HomeScreen: Screens("home")
    object AddScreen: Screens("addScreen")
}

