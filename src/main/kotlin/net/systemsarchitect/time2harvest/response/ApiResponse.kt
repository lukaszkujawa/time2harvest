package net.systemsarchitect.time2harvest.response

enum class ApiResponseStatus {
    OK, ERROR
}

data class ApiResponse<T>(val status: ApiResponseStatus, val data: T)