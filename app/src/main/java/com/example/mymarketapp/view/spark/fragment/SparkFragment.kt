package com.example.mymarketapp.view.spark.fragment

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymarketapp.R
import com.example.mymarketapp.view.spark.viewmodel.SparkViewModel

class SparkFragment : Fragment() {

    companion object {
        fun newInstance() = SparkFragment()
    }

    private val viewModel: SparkViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_spark, container, false)
    }
}