package com.meprogrammer.extraaedge.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import com.meprogrammer.extraaedge.R
import com.meprogrammer.extraaedge.utils.loadImageFromUrl
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapter(imageUrl: List<String>) :
    SliderViewAdapter<SliderAdapter.SliderViewHolder>() {

    private var sliderList: List<String> = imageUrl

    // on below line we are calling get method
    override fun getCount(): Int {
        return sliderList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): SliderViewHolder {
        val inflate: View =
            LayoutInflater.from(parent!!.context).inflate(R.layout.item_flicker_image, null)


        return SliderViewHolder(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderViewHolder?, position: Int) {

        viewHolder?.imageView?.loadImageFromUrl(viewHolder.itemView.context,sliderList[position])
    }

    class SliderViewHolder(itemView: View?) : SliderViewAdapter.ViewHolder(itemView) {


        var imageView: AppCompatImageView = itemView!!.findViewById(R.id.imageView)
    }
}