package com.ac.yeonsung.mj.retrofit_ex1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ac.yeonsung.mj.retrofit_ex1.databinding.ItemInfoBinding

class SubwayAdapter : RecyclerView.Adapter<SubwayAdapter.SubwayViewHolder>() {
    private var items = ArrayList<BodyModel>()

    inner class SubwayViewHolder(private val binding: ItemInfoBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(subwayroute: BodyModel){
            binding.subLnCd.text = subwayroute.lnCd
            binding.subStinCd.text = subwayroute.stinCd
            binding.subStinNm.text = subwayroute.stinNm
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : SubwayViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemInfoBinding.inflate(layoutInflater, parent, false)
        return SubwayViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: SubwayViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setList(subwayroute: ArrayList<BodyModel>) {
        items = subwayroute
    }
}