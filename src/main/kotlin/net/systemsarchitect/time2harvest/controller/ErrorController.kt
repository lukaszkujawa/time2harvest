package net.systemsarchitect.time2harvest.controller

import net.systemsarchitect.time2harvest.response.ApiResponse
import net.systemsarchitect.time2harvest.response.ApiResponseStatus
import net.systemsarchitect.time2harvest.response.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.request.WebRequest
import java.time.format.DateTimeParseException

@ControllerAdvice
class ErrorController {

    @ExceptionHandler(DateTimeParseException::class)
    fun dateTimeParseException(e: DateTimeParseException, request: WebRequest) : ResponseEntity<ApiResponse<ErrorMessage>> =
            ResponseEntity(ApiResponse(ApiResponseStatus.ERROR, ErrorMessage(1000, e.message)), HttpStatus.BAD_REQUEST)


    @ExceptionHandler(Time2HarvestControllerException::class)
    fun time2HarvestControllerException(e: Time2HarvestControllerException, request: WebRequest) : ResponseEntity<ApiResponse<ErrorMessage>> =
            ResponseEntity(ApiResponse(ApiResponseStatus.ERROR, ErrorMessage(1001, e.message)), HttpStatus.BAD_REQUEST)

}