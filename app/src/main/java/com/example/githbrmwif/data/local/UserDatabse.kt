package com.example.githbrmwif.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [FavoriteUser::class],
    version = 1
)
abstract class UserDatabse: RoomDatabase() {
    companion object{
        var INSTANCE : UserDatabse? = null

        fun getDatabase(context: Context): UserDatabse?{
            if (INSTANCE==null){
                synchronized(UserDatabse::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, UserDatabse::class.java, "user database").build()
                }
            }
            return INSTANCE
        }
    }

    abstract fun favoriteUserDao(): FavoriteUserDao
}