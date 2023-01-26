package com.example.githbrmwif.api

import com.example.githbrmwif.data.model.DetailUserResponse
import com.example.githbrmwif.data.model.User
import com.example.githbrmwif.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getUserDetail(
        @Path("username") username: String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}