package com.seda.remotejob.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.seda.remotejob.R
import com.seda.remotejob.adapter.JobAdapter
import com.seda.remotejob.databinding.FragmentRemoteJobBinding
import com.seda.remotejob.databinding.FragmentSearchBinding
import com.seda.remotejob.viewModel.RemoteJobViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var _binding: FragmentSearchBinding
    private val binding get() = _binding

    private val viewModel: RemoteJobViewModel by viewModels()
    private lateinit var jobAdapter: JobAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//search()
setUpRv()
    }

 /*   private fun search(){
        var job: Job?=null
        binding.etSearch.addTextChangedListener { text->
            job?.cancel()
            job= MainScope().launch {
                delay(500L)
                text.let {
                    if(text.toString().isNotEmpty()){
                        viewModel.search(text.toString())
                    }
                }
            }

        }


    }*/

    private fun setUpRv(){
        jobAdapter = JobAdapter()
        binding.rv.apply {
            adapter =jobAdapter
            layoutManager = GridLayoutManager(requireContext(),2)
            setHasFixedSize(true)
        }
        viewModel.res.observe(requireActivity()) { resultt ->

        }
    }

}