package com.seda.remotejob.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity(tableName = "jobtable")
data class Result(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val image: String,

    val name: String,




):Serializable