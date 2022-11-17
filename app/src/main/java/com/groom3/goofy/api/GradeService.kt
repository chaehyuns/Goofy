package com.groom3.goofy.api

import com.groom3.goofy.model.Grade
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GradeService {


    @GET("/wave-grade")
    suspend fun getGrade(
        @Query("spotCode") spotCode : Int
    ) : Response<Grade>
}