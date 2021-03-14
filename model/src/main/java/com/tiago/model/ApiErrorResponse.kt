package com.tiago.model

sealed class ApiErrorResponse : ApiResponse() {
    object ConnectionError : ApiErrorResponse()
    object NotFoundError : ApiErrorResponse()
    object InternalError : ApiErrorResponse()
    object ExceptionNotMapped : ApiErrorResponse()
}
