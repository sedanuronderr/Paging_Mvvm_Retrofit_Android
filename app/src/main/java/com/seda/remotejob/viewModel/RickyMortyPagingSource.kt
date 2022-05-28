package com.seda.remotejob.viewModel

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.seda.remotejob.api.RemoteJobResponse
import com.seda.remotejob.model.Result
import javax.inject.Inject

class RickyMortyPagingSource
    @Inject constructor(private val apiService: RemoteJobResponse):PagingSource<Int,Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {

return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {

        return try {
            val currentPage = params.key ?: 1
            val response = apiService.page(currentPage)
            val responseData = mutableListOf<Result>()
            val data = response.body()?.results ?: emptyList()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }

}
