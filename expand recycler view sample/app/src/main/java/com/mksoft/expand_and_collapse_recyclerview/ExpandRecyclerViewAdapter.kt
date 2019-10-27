package com.mksoft.expand_and_collapse_recyclerview

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mksoft.expand_and_collapse_recyclerview.databinding.HeadItemBinding
import java.util.*

class ExpandRecyclerViewAdapter(context:Context, rootList:MutableList<RootData>) : RecyclerView.Adapter<ExpandRecyclerViewAdapter.ViewHolder>() {
    var context:Context = context
    var rootList:MutableList<RootData> = Collections.emptyList()
    init {
        this.rootList = rootList
        this.context = context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.head_item, null)
        val binding = DataBindingUtil.bind<HeadItemBinding>(view)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return rootList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //루트 제목 바인딩
        holder.headItemBinding!!.headName.text = rootList[position].title
        val childAdapter = ChildRecyclerViewAdapter(this.context,
            rootList[position].childData as MutableList<ChildData>
        )
        //자식 어뎁터 바인딩
        holder.headItemBinding!!.rootRecyclerView.layoutManager = LinearLayoutManager(this.context)
        holder.headItemBinding!!.rootRecyclerView.setHasFixedSize(true)
        holder.headItemBinding!!.rootRecyclerView.adapter = childAdapter

        //버튼 바인딩
        holder.headItemBinding!!.nextButton.setOnClickListener {
            if(!rootList[position].expanded!!){
                expand(holder.headItemBinding!!.rootRecyclerView)
                rootList[position].expanded = true
            }else{

                collapse(holder.headItemBinding!!.rootRecyclerView)
                rootList[position].expanded = false
            }
        }

    }

    fun update(rootList:MutableList<RootData>){
        this.rootList = rootList
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: HeadItemBinding?) : RecyclerView.ViewHolder(itemView!!.root) {
        val headItemBinding = itemView

    }
}
