package com.mksoft.expand_and_collapse_recyclerview


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.mksoft.expand_and_collapse_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val testRootDataList = mutableListOf<RootData>()
    lateinit var mainBinding:ActivityMainBinding
    lateinit var expandRecyclerViewAdapter: ExpandRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        makeTestRootDataList()
        expandRecyclerViewAdapter = ExpandRecyclerViewAdapter(this, testRootDataList)
        mainBinding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
        mainBinding.mainRecyclerView.setHasFixedSize(true)
        mainBinding.mainRecyclerView.adapter = expandRecyclerViewAdapter


    }

    private fun makeTestRootDataList(){
        for(idx in 0 until 100){
            val currentChildList = mutableListOf<ChildData>()
            for(a in 'a' ..'z'){
                currentChildList.add(ChildData(a.toString()))
            }
            val currentRootData = RootData(idx.toString(), false, currentChildList)
            testRootDataList.add(currentRootData)
        }

    }
}
