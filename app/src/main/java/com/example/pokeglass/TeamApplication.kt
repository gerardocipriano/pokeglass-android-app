package com.example.pokeglass

import android.app.Application
import com.example.pokeglass.data.TeamRepository
import com.example.pokeglass.local.teamlocalservice.RoomTeamLocalService
import com.example.pokeglass.local.teamroomdatabase.TeamRoomDatabase

class TeamApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { TeamRoomDatabase.getDatabase(this) }
    val repository by lazy { TeamRepository(RoomTeamLocalService(database.teamDao())) }
}