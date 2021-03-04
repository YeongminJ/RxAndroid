package com.tnfg.mvvm.model

data class ResponseData(
    var total: Integer,
    var total_pages:Integer,
    var results: MutableList<PhotoData>
)

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

data class UserData (
    var id: String,
    var username: String,
    var name: String,
    var first_name: String,
    var last_name: String,
    var instagram_username: String,
    var twitter_username: String
)

data class UrlData (
    var raw: String,
    var full: String,
    var regular: String,
    var small: String,
    var thumb: String
)
