package com.example.harmonyhome.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Tag::class, Task::class], version = 1, exportSchema = false)
abstract class HarmonyHomeDb : RoomDatabase() {
    abstract fun tagDao(): TagDao
    abstract fun taskDao(): TaskDao


    companion object {
        fun getDatabase(context: Context): HarmonyHomeDb {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    HarmonyHomeDb::class.java,
                    "harmony_home_db"
                ).build().also { Instance = it }
            }
        }

        private var Instance: HarmonyHomeDb? = null
    }
}