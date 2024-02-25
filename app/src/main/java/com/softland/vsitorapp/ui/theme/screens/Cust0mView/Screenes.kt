package com.softland.vsitorapp.ui.theme.screens.Cust0mView

sealed class Screenes(val route:String){
      object loginScreen : Screenes("login")
      object homeScreen : Screenes("HomeScreen")
      object home : Screenes("Home")
      object preVisitScreen : Screenes("PreVisit")
      object regularScreen : Screenes("Regular")
      object settingsScreen : Screenes("Settings")
      object addVisitor : Screenes("AddVisitor")
      object departments : Screenes("Departments")
      object details : Screenes("Details")
      object filedetails : Screenes("Filedetails")
 }