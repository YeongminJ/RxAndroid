package com.example.myretrofit.retrofit

import android.icu.number.IntegerWidth

data class ResponseData(
    var total: Integer,
    var total_pages:Integer,
    var result: MutableList<PhotoData>
) {
    override fun toString(): String {
        var res = super.toString() +
         "\ntotal : ${total}, total_pages: ${total_pages} res : ${result}"
        return res
    }
}