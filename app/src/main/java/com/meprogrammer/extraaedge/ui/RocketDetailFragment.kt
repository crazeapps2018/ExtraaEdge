package com.meprogrammer.extraaedge.ui

import android.graphics.Paint
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.bold
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.meprogrammer.extraaedge.databinding.FragmentRoketsDetailsBinding
import com.meprogrammer.extraaedge.models.rocketsList.RocketsListDatum
import com.meprogrammer.extraaedge.ui.adapter.SliderAdapter
import com.meprogrammer.extraaedge.utils.NetworkResult
import com.meprogrammer.extraaedge.utils.makeStringBold
import com.meprogrammer.extraaedge.viewmodels.RocketsViewModel
import com.smarteist.autoimageslider.SliderView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RocketDetailFragment : Fragment() {

    private var _binding: FragmentRoketsDetailsBinding? = null
    private val binding get() = _binding!!
    private val rocketsViewModel by viewModels<RocketsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRoketsDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getString("id")
        if (id != null) {
            rocketsViewModel.getRocketDetail(id)
        }
        bindObservers()
    }



    private fun bindObservers() {
        rocketsViewModel.rocketDetailLiveData.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = false
            when (it) {
                is NetworkResult.Success -> {
                    setInitialData(it.data)
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

    private fun setInitialData(data: RocketsListDatum?) {

        data?.let {
            binding.tvName.text = data.name
            setFlickerImages(data.flickrImages!!)


            binding.tvActiveStatus.text = data.active.toString().makeStringBold("Active Status : ")
            binding.tvCostPerLaunch.text = data.costPerLaunch.toString().makeStringBold("Cost per Launch : ")
            binding.tvSuccessRate.text =data.successRatePct.toString().makeStringBold("Success Rate : ")

            binding.tvDes.text = data.description
            binding.tvLink.text = data.wikipedia
            binding.tvLink.paintFlags = binding.tvLink.paintFlags or Paint.UNDERLINE_TEXT_FLAG

            binding.tvHeight.text = data.height!!.feet.toString().makeStringBold("Height is : ")
            binding.tvDiameter.text = data.diameter!!.feet.toString().makeStringBold("Diameter is : ")


        }

    }


    private fun setFlickerImages(flickrImages: List<String>) {

        val sliderAdapter = SliderAdapter(flickrImages)
        binding.imageSlider.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
         binding.imageSlider.setSliderAdapter(sliderAdapter)
         binding.imageSlider.scrollTimeInSec = 3
         binding.imageSlider.isAutoCycle = true
         binding.imageSlider.startAutoCycle()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}