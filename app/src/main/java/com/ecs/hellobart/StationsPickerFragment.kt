package com.ecs.hellobart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ecs.hellobart.api.Station
import com.ecs.hellobart.databinding.StationsPickerFragmentBinding

class StationsPickerFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: StationsAdapater

    private lateinit var stations: List<Station>
    private lateinit var binding: StationsPickerFragmentBinding

    val viewModel : StationsPickerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = StationsPickerFragmentBinding.inflate(inflater, container, false)

        recyclerView = binding.stationsRecylerView
        viewAdapter = StationsAdapater()

        recyclerView.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = viewAdapter

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.stations.observe(viewLifecycleOwner, Observer {
            viewAdapter.updateStations(it.data.stations)
        })
    }
}