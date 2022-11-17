package com.groom3.goofy.db


class UserRepository(private val dao : UserDAO) {

    val users = dao.getAllUsers()

    suspend fun insert(user: User) : Long{
        return dao.insertUser(user)
    }
    suspend fun delete(user: User) : Int{
        return dao.deleteUser(user)
    }

    suspend fun deleteAll() : Int {
        return dao.deleteAll()
    }

}