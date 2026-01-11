package com.example.mymarketapp.view.dashboard.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymarketapp.R
import com.example.mymarketapp.databinding.ActivityDashboardBinding
import com.example.mymarketapp.view.dashboard.adapter.BottomMenuRecyclerAdapter
import com.example.mymarketapp.view.dashboard.model.BottomMenuItem
import com.example.mymarketapp.view.dashboard.viewModel.DashboardViewmodel

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    private lateinit var bottomMenuRecyclerAdapter: BottomMenuRecyclerAdapter

    private lateinit var navController: NavController

    private val viewModel: DashboardViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController

        setupRecycler()
        observeBottomMenuData()
    }

    private fun setupRecycler() {
        binding.bottomMenuRecyclerView.apply {

            //4th component
            layoutManager =
                LinearLayoutManager(this@DashboardActivity, RecyclerView.HORIZONTAL, false)

            bottomMenuRecyclerAdapter = BottomMenuRecyclerAdapter { selectedItem ->
                viewModel.onMenuSelected(selectedItem)
                navigateToTargetFragment(selectedItem)
            }
            //Step 3
            adapter = bottomMenuRecyclerAdapter
        }
    }

    private fun navigateToTargetFragment(selectedItem: BottomMenuItem) {

        val destination = when (selectedItem.title) {
            "Home" -> R.id.homeFragment
            "Search" -> R.id.searchFragment
            "Sparks" -> R.id.sparksFragment
            "Downloads" -> R.id.downloadsFragment
            "Myspace" -> R.id.mySpaceFragment
            else -> return

        }
        // Avoid navigating to same fragment again
        if (navController.currentDestination?.id != destination) {
            navController.navigate(destination)
        }
    }

    private fun observeBottomMenuData() {
        viewModel.menuItems.observe(this) { list ->

            //Step 1
            bottomMenuRecyclerAdapter.submitList(list)
        }
    }

}