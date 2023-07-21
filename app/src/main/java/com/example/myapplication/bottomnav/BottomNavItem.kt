package com.example.myapplication.bottomnav

import com.example.myapplication.R


sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Home : BottomNavItem("Home", R.drawable.ic_home, "Home")
    object Vehicle: BottomNavItem("Vehicle", R.drawable.ic_vehicle, "Vehicle")
    object Map: BottomNavItem("Map", R.drawable.ic_map, "Map")
    object Support: BottomNavItem("Support", R.drawable.ic_support, "Support")
    object Settings: BottomNavItem("Settings", R.drawable.ic_setting, "Settings")

}