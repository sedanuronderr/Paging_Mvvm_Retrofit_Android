package com.seda.remotejob.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.seda.remotejob.adapter.DetailAdapter
import com.seda.remotejob.adapter.JobAdapter
import com.seda.remotejob.databinding.FragmentSaveBinding
import com.seda.remotejob.databinding.JobCardBinding
import com.seda.remotejob.model.Result
import com.seda.remotejob.viewModel.RemoteJobViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SaveFragment : Fragment() {

    private lateinit var _binding: FragmentSaveBinding
    private val binding get() = _binding
    private val viewModel: RemoteJobViewModel by viewModels()
    private val bundle:SaveFragmentArgs by navArgs()
    private lateinit var jobAdapter: DetailAdapter
    lateinit var gelendelete :String
    lateinit var gelenad :String
    lateinit var gelenresim:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSaveBinding.inflate(layoutInflater,container,false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         gelenad = bundle.jobb.name
        gelenresim = bundle.jobb.image

        setupRv()
 saveTodo(view)


    }

    private fun setupRv() {
        jobAdapter = DetailAdapter(viewModel)
        binding.rvJobsSaved.apply {
            adapter = jobAdapter
            layoutManager =  GridLayoutManager(requireContext(),2)
            setHasFixedSize(true)
        }

        viewModel.getAllChar.observe(viewLifecycleOwner) { list ->
            update(list)
       jobAdapter.differ.submitList(list)
        }
    }
    private fun saveTodo(mView:View){

        val jobroom = Result(0,gelenresim,gelenad)
       viewModel.insertChar(jobroom)


            Snackbar.make(
                mView," added",
                Snackbar.LENGTH_SHORT
            ).show()


    }

    private fun update(list: List<Result>){
        if(list.isNotEmpty()){
            binding.rvJobsSaved.visibility =View.VISIBLE


        }else{
            binding.rvJobsSaved.visibility =View.GONE

        }
    }

}