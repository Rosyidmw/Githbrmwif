package com.example.githbrmwif.ui.favorite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.githbrmwif.data.local.FavoriteUser
import com.example.githbrmwif.data.local.FavoriteUserDao
import com.example.githbrmwif.data.local.UserDatabse

class FavoriteViewModel(application: Application): AndroidViewModel(application) {

    private var userDao: FavoriteUserDao?
    private var userDb: UserDatabse?

    init {
        userDb = UserDatabse.getDatabase(application)
        userDao = userDb?.favoriteUserDao()
    }

    fun getFavoriteUser(): LiveData<List<FavoriteUser>>? {
        return userDao?.getFavoriteUser()
    }
}