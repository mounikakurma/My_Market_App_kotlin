package com.example.mymarketapp.view.mySpace.fragment

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymarketapp.R
import com.example.mymarketapp.view.mySpace.viewmodel.MyspaceViewModel

class MyspaceFragment : Fragment() {

    companion object {
        fun newInstance() = MyspaceFragment()
    }

    private val viewModel: MyspaceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_myspace, container, false)
    }
}