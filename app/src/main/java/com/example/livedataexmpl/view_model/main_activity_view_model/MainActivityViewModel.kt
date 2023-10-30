package com.example.livedataexmpl.view_model.main_activity_view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel:ViewModel() {
    var indexNumber:Int = 0


    private val _currentIndex:MutableLiveData<Int> = MutableLiveData()
    val currentIndex:LiveData<Int> get() = _currentIndex

    fun getNumber():LiveData<Int> = currentIndex
    fun setNumber(int:Int) {
        _currentIndex.value = int
    }
}