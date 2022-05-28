package com.seda.remotejob.viewModel

import android.util.Log
import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.seda.remotejob.api.RemoteJobResponse
import com.seda.remotejob.model.Result
import com.seda.remotejob.model.characterr
import com.seda.remotejob.repository.JobRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RemoteJobViewModel
@Inject
   constructor(private val repository:JobRepository,private val apiService: RemoteJobResponse):ViewModel(){
    private val _response = MutableLiveData<characterr>()
    val responsejob: LiveData<characterr>
        get() = _response

    private val _res = MutableLiveData<characterr>()
    val res: LiveData<characterr>
        get() = _res

    init {
        getAllTvShows()
    }


        val listData = Pager(PagingConfig(pageSize = 1)) {
            RickyMortyPagingSource(apiService)

        }.flow.cachedIn(viewModelScope)


 fun search(query:String)= viewModelScope.launch {
       /* repository.getsearch(query).let { response->
            if(response.isSuccessful){
                _res.postValue(response.body())
            }else{
                Log.d("your tag",
                    "getAllImages Error: ${response.errorBody()}")
            }
        }
*/
    }

    private fun getAllTvShows() = viewModelScope.launch {

        repository.getRemoteJob().let { response->
   if(response.isSuccessful){
       _response.postValue(response.body())
   }else{
       Log.d("your tag",
           "getAllImages Error: ${response.errorBody()}")
   }


        }
    }
    fun insertChar(roomjob:Result)=viewModelScope.launch {

       repository.insertTodo(roomjob)
    }

    fun deleteChar(roomjob:Result)=viewModelScope.launch {
        repository.delete(roomjob)
    }

    val getAllChar = repository.getAllToDos().asLiveData()

}






