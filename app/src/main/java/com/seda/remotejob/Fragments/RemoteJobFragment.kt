package com.seda.remotejob.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.seda.remotejob.R
import com.seda.remotejob.adapter.JobAdapter
import com.seda.remotejob.databinding.FragmentMainBinding
import com.seda.remotejob.databinding.FragmentRemoteJobBinding
import com.seda.remotejob.viewModel.RemoteJobViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RemoteJobFragment : Fragment() {
    private lateinit var _binding: FragmentRemoteJobBinding
    private val binding get() = _binding

    private val viewModel: RemoteJobViewModel by viewModels()
    private lateinit var jobAdapter: JobAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRemoteJobBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        setUpRv()
    }
    private fun setUpRv(){
        jobAdapter = JobAdapter()
        binding.rvRecipe.apply {
            adapter =jobAdapter
            layoutManager = GridLayoutManager(requireContext(),2)
            setHasFixedSize(true)
        }
        lifecycleScope.launch {
            viewModel.listData.collect { resultt ->

                jobAdapter.submitData(resultt)
            }
        }
    }
}