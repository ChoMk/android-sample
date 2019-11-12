package com.mksoft.snakerecyclerviewsample

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.NetworkImageView
import com.bumptech.glide.Glide
import com.mksoft.mkjw_second_project.App
import com.mksoft.snakerecyclerviewsample.databinding.SnakeItemFirstBinding
import com.mksoft.snakerecyclerviewsample.databinding.SnakeItemSecondBinding
import com.mksoft.snakerecyclerviewsample.databinding.SnakeItemThirdBinding

class SnakeAdapter (context: Context, itemList:List<ItemData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private val context = context
    private val itemList = itemList

    override fun getItemViewType(position: Int): Int {
        return position % 3
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            0 -> {
                val layoutId = R.layout.snake_item_first
                val layoutView = LayoutInflater.from(context).inflate(layoutId, parent, false)
                val binding = DataBindingUtil.bind<SnakeItemFirstBinding>(layoutView)
                return SnakeFirstViewHolder(binding)
            }
            1 -> {
                val layoutId = R.layout.snake_item_second
                val layoutView = LayoutInflater.from(context).inflate(layoutId, parent, false)
                val binding = DataBindingUtil.bind<SnakeItemSecondBinding>(layoutView)
                return SnakeSecondViewHolder(binding)
            }
            else -> {
                val layoutId = R.layout.snake_item_third
                val layoutView = LayoutInflater.from(context).inflate(layoutId, parent, false)
                val binding = DataBindingUtil.bind<SnakeItemThirdBinding>(layoutView)
                return SnakeThirdViewHolder(binding)
            }
        }

    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int){
        when(position%3){
            0->{
                (holder as SnakeFirstViewHolder).bindedView!!.productTitle.text = itemList[position].likeCount.toString()
                //ImageRequester.setImageFromUrl(holder.bindedView!!.productImage, itemList[position].imageSrc!!)
                //Glide.with(App.applicationContext()).load(itemList[position].imageSrc!!).into(holder.bindedView!!.productImage)
            }
            1->{
                (holder as SnakeSecondViewHolder).bindedView!!.productTitle.text = itemList[position].likeCount.toString()
                //ImageRequester.setImageFromUrl(holder.bindedView!!.productImage, itemList[position].imageSrc!!)
                //Glide.with(App.applicationContext()).load(itemList[position].imageSrc!!).into(holder.bindedView!!.productImage)

            }
            else ->{
                (holder as SnakeThirdViewHolder).bindedView!!.productTitle.text = itemList[position].likeCount.toString()
                //ImageRequester.setImageFromUrl(holder.bindedView!!.productImage, itemList[position].imageSrc!!)
                //Glide.with(App.applicationContext()).load(itemList[position].imageSrc!!).into(holder.bindedView!!.productImage)

            }
        }
    }
    override fun getItemCount(): Int {
        return itemList.size
    }

    class SnakeFirstViewHolder(itemView:SnakeItemFirstBinding?) : RecyclerView.ViewHolder(itemView!!.root){
        val bindedView = itemView
    }
    class SnakeSecondViewHolder(itemView:SnakeItemSecondBinding?):RecyclerView.ViewHolder(itemView!!.root){
        val bindedView = itemView
    }
    class SnakeThirdViewHolder(itemView: SnakeItemThirdBinding?):RecyclerView.ViewHolder(itemView!!.root){
        val bindedView = itemView
    }
}