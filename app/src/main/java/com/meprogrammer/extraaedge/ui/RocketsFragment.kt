package com.meprogrammer.extraaedge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.meprogrammer.extraaedge.R
import com.meprogrammer.extraaedge.databinding.FragmentRocketsBinding
import com.meprogrammer.extraaedge.ui.adapter.RocketAdapter
import com.meprogrammer.extraaedge.utils.NetworkResult
import com.meprogrammer.extraaedge.viewmodels.RocketsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RocketsFragment : Fragment() {

    private var _binding: FragmentRocketsBinding? = null
    private val binding get() = _binding!!

    private val rocketsViewModel by viewModels<RocketsViewModel>()
    private lateinit var adapter: RocketAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRocketsBinding.inflate(inflater, container, false)
        adapter = RocketAdapter(::onRocketClick)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindObservers()
        rocketsViewModel.getRocketsList()
        binding.rocketList.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.rocketList.adapter = adapter

    }

    private fun bindObservers() {
        rocketsViewModel.rocketsLiveData.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = false
            when (it) {
                is NetworkResult.Success -> {
                    adapter.submitList(it.data)

                }
                is NetworkResult.Error -> Toast.makeText(
                    requireContext(),
                    it.message.toString(),
                    Toast.LENGTH_SHORT
                ).show()
                is NetworkResult.Loading -> binding.progressBar.isVisible = true

            }
        }
    }

    private fun onRocketClick(id: String){
        val bundle = Bundle()
        bundle.putString("id", id)
        findNavController().navigate(R.id.action_mainFragment_to_rocketDetailFragment,bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}