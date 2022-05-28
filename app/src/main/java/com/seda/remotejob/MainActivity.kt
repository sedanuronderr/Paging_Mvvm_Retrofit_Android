package com.seda.remotejob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.marginLeft
import com.seda.remotejob.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // setSupportActionBar(binding.toolbar)
      //  supportActionBar?.title="Rick Morty"

    }
}