package com.groom3.goofy.db

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: User) : Long // return row ID

    @Delete
    suspend fun deleteUser(user: User) : Int

    @Query("DELETE FROM user_data_table")
    suspend fun deleteAll() : Int

    @Query("SELECT * FROM user_data_table")
    fun getAllUsers(): LiveData<List<User>>
}

