package com.example.mymarketapp.view.dashboard.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymarketapp.R
import com.example.mymarketapp.view.dashboard.model.BottomMenuItem

class DashboardViewmodel : ViewModel() {
    private val _menuItems = MutableLiveData<List<BottomMenuItem>>()
    val menuItems: LiveData<List<BottomMenuItem>> = _menuItems

    init {
        loadMenu()
    }

    //1. Data Component
    private fun loadMenu() {
      _menuItems.value = listOf(
          BottomMenuItem(1, "Home",R.drawable.home,true),
          BottomMenuItem(2, "Search",R.drawable.search,false),
          BottomMenuItem(3,"Sparks", R.drawable.sparks,false),
          BottomMenuItem(4,"Downloads",R.drawable.downloads,false),
          BottomMenuItem(5, "Myspace", R.drawable.my_space, false)
      )
    }

    fun onMenuSelected (selectedItem: BottomMenuItem) {
        _menuItems.value = _menuItems.value?.map {
            it.copy(isSelected = it.id == selectedItem.id)
        }
    }
}