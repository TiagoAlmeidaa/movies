package com.tiago.network.repository

import com.tiago.model.ApiErrorResponse
import com.tiago.model.ApiMoviesResponse
import com.tiago.network.datasource.MoviesDataSource
import com.tiago.network.rule.RxSchedulerRule
import com.tiago.network.util.HttpCodes
import com.tiago.network.util.Keys
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.HttpException
import java.lang.Exception
import java.net.UnknownHostException

@RunWith(JUnit4::class)
class MoviesRepositoryImplTest {

    @get:Rule
    var rxSchedulerRule: RxSchedulerRule = RxSchedulerRule()

    private lateinit var repository: MoviesRepositoryImpl

    @MockK
    private lateinit var dataSource: MoviesDataSource

    private val apiKey = "fake api key"

    @Before
    fun setup() {
        MockKAnnotations.init(this)

        repository = MoviesRepositoryImpl(dataSource, apiKey)
    }

    @Test
    fun `getPopularMovies() should return ExceptionNotMapped for exceptions that are not expected`() {
        val exception = Exception()
        val page = 1
        val response = ApiErrorResponse.ExceptionNotMapped

        every {
            dataSource.getPopularMovies(apiKey, page)
        }.returns(Single.error(exception))

        repository.getPopularMovies(page)
            .test()
            .assertValue(response)
            .dispose()
    }

    @Test
    fun `getPopularMovies() should return ConnectionError for exceptions that are UnknownHostException`() {
        val exception = UnknownHostException()
        val page = 1
        val response = ApiErrorResponse.ConnectionError

        every {
            dataSource.getPopularMovies(apiKey, page)
        }.returns(Single.error(exception))

        repository.getPopularMovies(page)
            .test()
            .assertValue(response)
            .dispose()
    }

    @Test
    fun `getPopularMovies() should return NotFoundError for exceptions that are HttpException with code 404`() {
        val exception = mockk<HttpException>()

        every {
            exception.code()
        }.returns(HttpCodes.NOT_FOUND)

        val page = 1
        val response = ApiErrorResponse.NotFoundError

        every {
            dataSource.getPopularMovies(apiKey, page)
        }.returns(Single.error(exception))

        repository.getPopularMovies(page)
            .test()
            .assertValue(response)
            .dispose()
    }

    @Test
    fun `getPopularMovies() should return InternalError for exceptions that are HttpException with code 500`() {
        val exception = mockk<HttpException>()

        every {
            exception.code()
        }.returns(HttpCodes.INTERNAL)

        val page = 1
        val response = ApiErrorResponse.InternalError

        every {
            dataSource.getPopularMovies(apiKey, page)
        }.returns(Single.error(exception))

        repository.getPopularMovies(page)
            .test()
            .assertValue(response)
            .dispose()
    }

    @Test
    fun `getPopularMovies() should return ExceptionNotMapped for exceptions that are HttpException with not known code`() {
        val randomCode = 123
        val exception = mockk<HttpException>()

        every {
            exception.code()
        }.returns(randomCode)

        val page = 1
        val response = ApiErrorResponse.ExceptionNotMapped

        every {
            dataSource.getPopularMovies(apiKey, page)
        }.returns(Single.error(exception))

        repository.getPopularMovies(page)
            .test()
            .assertValue(response)
            .dispose()
    }

    @Test
    fun `getPopularMovies() should return the expected movies list`() {
        val page = 1
        val response = ApiMoviesResponse(page, mutableListOf())

        every {
            dataSource.getPopularMovies(apiKey, page)
        }.returns(Single.just(response))

        repository.getPopularMovies(page)
            .test()
            .assertValue(response)
            .dispose()
    }

}