package com.seda.remotejob.api

import androidx.room.Database
import androidx.room.RoomDatabase
import com.seda.remotejob.model.Result

@Database(entities = [Result::class], version = 1, exportSchema = false)
abstract class jobDatabase : RoomDatabase() {
abstract  fun jobdao():jobDao
}