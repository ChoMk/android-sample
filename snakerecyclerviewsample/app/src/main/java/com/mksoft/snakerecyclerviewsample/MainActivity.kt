package com.mksoft.snakerecyclerviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mksoft.snakerecyclerviewsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val testList:List<ItemData> =makeTestSample()
    lateinit var mainBinding: ActivityMainBinding
    lateinit var snakeAdapter: SnakeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        snakeAdapter = SnakeAdapter(this, testList)
        mainBinding.mainRecyclerView.setHasFixedSize(true)

        val gridLayoutManager = GridLayoutManager(this, 2, RecyclerView.HORIZONTAL, false)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position % 3 == 2) 2 else 1
            }
        }
        mainBinding.mainRecyclerView.layoutManager = gridLayoutManager
        val largePadding = resources.getDimensionPixelSize(R.dimen.shr_staggered_product_grid_spacing_large)
        val smallPadding = resources.getDimensionPixelSize(R.dimen.shr_staggered_product_grid_spacing_small)

        mainBinding.mainRecyclerView.adapter = snakeAdapter
        mainBinding.mainRecyclerView.addItemDecoration(ProductGridItemDecoration(largePadding, smallPadding))
    }
    private fun makeTestSample():List<ItemData>{
        val tempList:MutableList<ItemData> = mutableListOf()
        for(idx in 0..10){
            tempList.add(ItemData(idx, "https://github.com/MKJW/second_project_client/blob/master/GIF/boardTest.gif"))
        }
        return tempList
    }
}
