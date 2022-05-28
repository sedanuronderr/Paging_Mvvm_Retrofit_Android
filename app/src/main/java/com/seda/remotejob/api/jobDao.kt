package com.seda.remotejob.api

import androidx.room.*
import com.seda.remotejob.model.Result
import kotlinx.coroutines.flow.Flow

@Dao
interface jobDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserTodo(job : Result)

    @Delete
    suspend fun deletetodo(todo: Result)

    @Query("SELECT * FROM jobtable ORDER BY id ASC ")
    fun getAllJob():Flow<List<Result>>
}