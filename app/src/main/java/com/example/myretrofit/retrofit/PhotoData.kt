package com.example.myretrofit.retrofit

data class PhotoData(
    var id: String,
    var created_at: String,
    var width: Integer,
    var height: Integer,
    var color: String,
    var blur_hash: String,
    var likes: Integer,
    var liked_by_user: Boolean,
    var description: String,
    var user: UserData,
    var urls: UrlData
)