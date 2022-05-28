package com.seda.remotejob.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.seda.remotejob.Fragments.RemoteJobFragmentDirections

import com.seda.remotejob.databinding.JobCardBinding
import com.seda.remotejob.model.Result
import com.seda.remotejob.model.characterr

class JobAdapter: PagingDataAdapter<Result, JobAdapter.MyViewHolder>(diffCallback  ) {
   // private var binding: JobCardBinding? = null
  inner class MyViewHolder(val binding:JobCardBinding) :RecyclerView.ViewHolder(binding.root){

    }
    companion object {
 val diffCallback= object :DiffUtil.ItemCallback<Result>(){
    override fun areItemsTheSame(oldItem:Result, newItem:Result): Boolean {

        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem:Result, newItem: Result): Boolean {

        return oldItem == newItem
    }


}}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
return MyViewHolder(JobCardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
val currentJob = getItem(position)

  holder.binding.apply {

      tvTitleRecipe.text= currentJob?.name
      imageView.load(currentJob?.image){
          crossfade(true)
          crossfade(1000)
      }
  }



        holder.itemView.setOnClickListener {mView->
            val direction = RemoteJobFragmentDirections.actionRemoteJobFragmentToSaveFragment(currentJob!!)
            mView.findNavController().navigate(direction)

        }



    }


}