package com.mksoft.expand_and_collapse_recyclerview

import java.util.*

data class RootData(
    val title:String?="null",
    var expanded:Boolean?=true,
    val childData: List<ChildData>?=Collections.emptyList()
)
