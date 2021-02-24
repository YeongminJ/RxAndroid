package com.example.myretrofit.retrofit

import android.icu.number.IntegerWidth

data class ResponseData(
    var total: Integer,
    var total_pages:Integer,
    var result: MutableList<PhotoData>
)