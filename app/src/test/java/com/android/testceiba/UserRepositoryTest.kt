package com.android.testceiba

import com.android.testceiba.api.UserRepository
import com.android.testceiba.api.WebService
import com.android.testceiba.userdetail.model.Post
import com.android.testceiba.usermain.model.User
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import retrofit2.Response

class UserRepositoryTest {
    val userRepository = UserRepository(WebService.getInstance())
    @Test
    fun getUsers_isCorrect_fullList() = runBlocking {
        //Arrange
        val sizeList = 0

        //Act
        val result: Response<List<User>> = userRepository.getUsers()

        //Assert
        Assert.assertNotEquals(sizeList, result.body()?.size)
    }

    @Test
    fun getUsers_isCorrect_fieldNameExist() = runBlocking {
        //Arrange

        //Act
        val result: Response<List<User>> = userRepository.getUsers()

        //Assert
        Assert.assertNotNull(result.body()!![0].name)
    }

    @Test
    fun getUsers_isFailure_nullList() = runBlocking {
        //Arrange

        //Act
        val result: Response<List<User>> = userRepository.getUsers()

        //Assert
        Assert.assertNotNull(result.body())
    }

    @Test
    fun getPost_isCorrect_fullList() = runBlocking {
        //Arrange
        val sizeList = 0
        val userId = "1"

        //Act
        val result: Response<List<Post>> = userRepository.getPost(userId)

        //Assert
        Assert.assertNotEquals(sizeList, result.body()?.size)
    }

    @Test
    fun getPost_isFailure_emptyList() = runBlocking {
        //Arrange
        val userId = "11"

        //Act
        val result: Response<List<Post>> = userRepository.getPost(userId)

        //Assert
        Assert.assertTrue(result.body()?.isEmpty()!!)
    }

}