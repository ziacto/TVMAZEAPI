package com.lovoo.android.tvmaze.data.api

import io.reactivex.observers.DisposableObserver
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

abstract class ApiCallback<T : Any> : DisposableObserver<T>() {

    protected abstract fun onSuccess(t: T)

    protected abstract fun onError(any: Any)

    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(e: Throwable) {
        when (e) {
            is HttpException -> {
                val responseBody = (e).response().errorBody()
                responseBody?.let {
                    onError(getErrorMessage(it))
                }
            }
            is SocketTimeoutException -> {
                onError("Time out Error")
            }
            is IOException -> {
                onError("Network Exception")
            }
            else -> {
                e.message?.let {
                    onError("UnknownException")
                }
            }
        }
    }


    override fun onComplete() {

    }

    private fun getErrorMessage(responseBody: ResponseBody): String {
        val jsonObject = JSONObject(responseBody.string())
        return jsonObject.getString(("message"))
    }
}