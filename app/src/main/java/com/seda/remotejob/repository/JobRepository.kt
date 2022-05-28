package com.seda.remotejob.repository


import com.seda.remotejob.api.RemoteJobResponse
import com.seda.remotejob.api.jobDao
import com.seda.remotejob.model.Result
import javax.inject.Inject

class JobRepository
@Inject
constructor(private val apiService: RemoteJobResponse,private val dao: jobDao) {
    suspend fun getRemoteJob() = apiService.getRemoteJobResponse()




    suspend fun insertTodo(job:Result)= dao.inserTodo(job)

    suspend fun delete(job:Result)=dao.deletetodo(job)
    fun getAllToDos()= dao.getAllJob()

}