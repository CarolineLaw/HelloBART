package com.ecs.hellobart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ecs.hellobart.api.Station
import com.ecs.hellobart.databinding.StationItemBinding
import okhttp3.internal.notify

class StationsAdapater() :
    RecyclerView.Adapter<StationsAdapater.StationItemViewHolder>() {

    private var stations: List<Station> = emptyList()

    class StationItemViewHolder(val binding: StationItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(station: Station) {
            binding.stationNameTextView.text = station.stationName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): StationItemViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = StationItemBinding.inflate(inflater, parent, false)

        return StationItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StationItemViewHolder, position: Int) {
        holder.bind(stations[position])
    }

    override fun getItemCount() = stations.size

    fun updateStations(stations: List<Station>){
        this.stations = stations
        notifyDataSetChanged()
    }
}