package com.seda.remotejob.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.seda.remotejob.Fragments.RemoteJobFragmentDirections
import com.seda.remotejob.databinding.DetailCardBinding

import com.seda.remotejob.databinding.JobCardBinding
import com.seda.remotejob.model.Result
import com.seda.remotejob.model.characterr
import com.seda.remotejob.viewModel.RemoteJobViewModel

class DetailAdapter(  private val viewmodel:RemoteJobViewModel): RecyclerView.Adapter<DetailAdapter.MyViewHolder>() {
   // private var binding: JobCardBinding? = null
  inner class MyViewHolder(val binding:DetailCardBinding) :RecyclerView.ViewHolder(binding.root){

    }
private val diffCallback= object :DiffUtil.ItemCallback<Result>(){
    override fun areItemsTheSame(oldItem:Result, newItem:Result): Boolean {

        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem:Result, newItem: Result): Boolean {

        return oldItem == newItem
    }


}
 val differ = AsyncListDiffer(this, diffCallback)
var job :List<Result>
 get() = differ.currentList
    set(value) {
        differ.submitList(value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
return MyViewHolder(DetailCardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
val currentJob = job[position]

  holder.binding.apply {

      tvTitleRecipe1.text= currentJob.name
      imageView1.load(currentJob.image){
          crossfade(true)
          crossfade(1000)
      }

  }
        holder.binding.imageView5.apply {
            setOnClickListener {
                holder.binding.apply {
 viewmodel.deleteChar(currentJob)
                }
            }
        }







    }

    override fun getItemCount(): Int {

return job.size

    }
}