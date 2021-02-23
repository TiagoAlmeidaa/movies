package com.tiago.movies

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tiago.network.repository.MoviesRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {

//    @Inject
//    lateinit var repository: MoviesRepository

//    val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        (applicationContext as MoviesApplication).appComponent.inject(this)

//        val disposable = repository.get().subscribe(
//            { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() },
//            { Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show() }
//        )

//        compositeDisposable.add(disposable)
    }

    override fun onDestroy() {
//        compositeDisposable.clear()
        super.onDestroy()
    }
}