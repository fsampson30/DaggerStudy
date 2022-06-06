package com.sampson.daggerstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sampson.daggerstudy.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        (application as RandomApplication).applicationComponent.createMainSubComponent().inject(this)

        val viewModel = ViewModelProvider(this,factory).get(MainViewModel::class.java)

        viewModel.getLiveData().observe(this, Observer {
            binding.activityMainTextView.text = it.toString()
        })

        binding.activityMainButton.setOnClickListener {
            viewModel.generateNextNumber()
        }
    }
}