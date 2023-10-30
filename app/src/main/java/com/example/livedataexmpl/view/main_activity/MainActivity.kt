package com.example.livedataexmpl.view.main_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.livedataexmpl.view_model.main_activity_view_model.MainActivityViewModel
import com.example.livedataexmpl.R
import com.example.livedataexmpl.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var vm: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        changeDrawabble()

    }

    fun init() {
        vm = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    fun changeDrawabble() {
        binding.btnClick.setOnClickListener {
            if (vm.indexNumber.equals(0)) vm.setNumber(++vm.indexNumber) else vm.setNumber(--vm.indexNumber)
        }
        setDrawable()
    }

    fun setDrawable() {
        val listDrawable = listOf(
            R.drawable.run,
            R.drawable.walk
        )
        vm.getNumber().observe(this) {index ->
          binding.ivAnim.setImageResource(listDrawable[index])
        }
    }
}