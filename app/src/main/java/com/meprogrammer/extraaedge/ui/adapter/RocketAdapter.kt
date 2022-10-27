package com.meprogrammer.extraaedge.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.meprogrammer.extraaedge.databinding.RocketItemBinding
import com.meprogrammer.extraaedge.models.rocketsList.RocketsListDatum
import com.meprogrammer.extraaedge.utils.loadImageFromUrl
import com.meprogrammer.extraaedge.utils.makeStringBold
import kotlin.reflect.KFunction1

class RocketAdapter(private val onRocketClicked: KFunction1<String, Unit>) :
    ListAdapter<RocketsListDatum,RocketAdapter.RocketsViewHolder>(ComparatorDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketsViewHolder {
        val binding = RocketItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RocketsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RocketsViewHolder, position: Int) {
        val rocket = getItem(position)
        rocket?.let {
            holder.bind(it)
        }
    }

    inner class RocketsViewHolder(private val binding: RocketItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(rocket: RocketsListDatum) {
            binding.name.text = rocket.name
            binding.country.text = rocket.country
            binding.enginesCount.text = rocket.engines!!.number.toString().makeStringBold("Engines Count : ")

            binding.flickerImage.loadImageFromUrl(binding.flickerImage.context,
                rocket.flickrImages!![0]
            )

            binding.root.setOnClickListener {
                onRocketClicked(rocket.id)
            }
        }

    }

    class ComparatorDiffUtil : DiffUtil.ItemCallback<RocketsListDatum>() {
        override fun areItemsTheSame(oldItem: RocketsListDatum, newItem: RocketsListDatum): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RocketsListDatum, newItem: RocketsListDatum): Boolean {
            return oldItem.equals(newItem)
        }
    }


}