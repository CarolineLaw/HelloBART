package com.ecs.hellobart

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.ecs.hellobart.databinding.TrainCountFragmentBinding

class TrainCountFragment : Fragment() {

    companion object {
        fun newInstance() = TrainCountFragment()
    }

    private val viewModel: TrainCountViewModel by viewModels()
    private lateinit var binding: TrainCountFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TrainCountFragmentBinding.inflate(inflater, container, false)

        setupBindings()

        return binding.root
    }

    private fun setupBindings() {
//        viewModel.trainCount.observe(viewLifecycleOwner, Observer {
//            binding.trainCount.text = it.data.trainCount.toString()
//        })

        viewModel.stations.observe(viewLifecycleOwner, Observer {
            binding.trainCount.text = it.data.stations.joinToString(", ") { it.stationName }
        })
    }


}