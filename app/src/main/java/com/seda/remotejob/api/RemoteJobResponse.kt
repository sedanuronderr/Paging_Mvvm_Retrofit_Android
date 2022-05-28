package com.seda.remotejob.api

import com.seda.remotejob.model.characterr
import com.seda.remotejob.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteJobResponse {

    @GET(Constants.END_POINT)
  suspend  fun getRemoteJobResponse(): Response<characterr>

    @GET(Constants.END_POINT)
    suspend  fun page(@Query("page") page:Int): Response<characterr>
}