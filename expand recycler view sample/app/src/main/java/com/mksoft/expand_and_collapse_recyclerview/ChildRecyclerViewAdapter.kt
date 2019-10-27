package com.mksoft.expand_and_collapse_recyclerview


import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mksoft.expand_and_collapse_recyclerview.databinding.ChildItemBinding
import com.mksoft.expand_and_collapse_recyclerview.databinding.HeadItemBinding
import java.util.*

class ChildRecyclerViewAdapter(context:Context, childDataList:MutableList<ChildData>) : RecyclerView.Adapter<ChildRecyclerViewAdapter.ViewHolder>() {
    var context:Context = context
    var childDAtaList:MutableList<ChildData>

    init {
        this.childDAtaList = childDataList
        this.context = context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.child_item, null)
        val binding = DataBindingUtil.bind<ChildItemBinding>(view)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return childDAtaList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.childDataBinding!!.childId.text = childDAtaList[position].title

    }
    fun update(childDataList:MutableList<ChildData>){
        childDAtaList = childDataList
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: ChildItemBinding?) : RecyclerView.ViewHolder(itemView!!.root) {
        val childDataBinding = itemView

    }
}
