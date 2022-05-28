package com.seda.remotejob.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems

import com.seda.remotejob.databinding.FragmentMainBinding

class MainFragment : Fragment() {
private lateinit var _binding:FragmentMainBinding
    private val binding get() = _binding
    private val fragmentList = ArrayList<Fragment>()
    private val baslikList = ArrayList<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // setUpTabBar()
    }

 /*   private fun setUpTabBar() {

        fragmentList.add(RemoteJobFragment())

        fragmentList.add(SearchFragment())
        fragmentList.add(SaveFragment())

  //fragmentlist ekleniyor
        val adapter = MyviewPagerAdapter(requireActivity())
        binding.viewpager2.adapter = adapter
//basliklar
        baslikList.add("Jobs")
        baslikList.add("Search")
        baslikList.add("Save")


        TabLayoutMediator(binding.tabLayout,binding.viewpager2) { tab, position ->
            tab.setText(baslikList[position])

        }.attach()
    }
    inner class MyviewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int {
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
        }


    }*/
}