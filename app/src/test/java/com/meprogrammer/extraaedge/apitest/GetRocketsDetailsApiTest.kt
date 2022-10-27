package com.meprogrammer.extraaedge.apitest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.meprogrammer.extraaedge.api.RocketsAPI
import com.meprogrammer.extraaedge.repository.RocketRepository
import com.meprogrammer.extraaedge.utils.Constants.BASE_URL
import com.meprogrammer.extraaedge.utils.MockResponseFileReader
import junit.framework.Assert
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.json.JSONObject
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@RunWith(JUnit4::class)
class GetRocketsDetailsApiTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    private val server = MockWebServer()


    private lateinit var repository: RocketRepository
    private lateinit var mockedResponse: String

    private val gson = GsonBuilder()
        .setLenient()
        .create()

    @Before
    fun init() {
        server.start(8000)
        val okHttpClient = OkHttpClient
            .Builder()
            .build()
        val service = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build().create(RocketsAPI::class.java)
        repository = RocketRepository(service, null,null )
    }
    @Test
    fun testApiSuccess() {
        mockedResponse = MockResponseFileReader("rockets.json").content
        server.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(mockedResponse)
        )
        val response = runBlocking {
            repository.rocketsAPI.getRockets()
        }
        val json = gson.toJson(response.body())


        val parser = JsonParser()
        val resultResponse = parser.parse(json)
        val expectedresponse = parser.parse(mockedResponse)
        assertEquals(resultResponse, expectedresponse)
        Assert.assertNotNull(response)
        Assert.assertTrue(resultResponse.equals(expectedresponse))
    }
    @After
    fun tearDown() {
        server.shutdown()
    }

}