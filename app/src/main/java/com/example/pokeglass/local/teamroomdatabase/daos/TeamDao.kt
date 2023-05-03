package com.example.pokeglass.local.teamroomdatabase.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokeglass.local.teamroomdatabase.entities.TeamEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(teamMember: TeamEntity)

    @Query("SELECT * FROM team_table")
    fun getAll(): Flow<List<TeamEntity>>

    @Query("DELETE FROM team_table WHERE name = :name")
    fun deleteByName(name: String)
}