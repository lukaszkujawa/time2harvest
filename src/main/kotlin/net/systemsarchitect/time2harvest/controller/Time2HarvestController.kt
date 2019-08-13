package net.systemsarchitect.time2harvest.controller

import net.systemsarchitect.time2harvest.response.ApiResponse
import net.systemsarchitect.time2harvest.response.ApiResponseStatus
import net.systemsarchitect.time2harvest.response.Time2Harvest
import net.systemsarchitect.time2harvest.utils.daysToFromString
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception
import kotlin.math.absoluteValue

class Time2HarvestControllerException(message: String?) : Exception(message)

@RestController
class Time2HarvestController {

    @GetMapping("/")
    fun greeting(@RequestParam(value = "to") to: String) : ApiResponse<Time2Harvest> {
        val daysLeft = daysToFromString(to)

        /**
         * For the purpose of this exercise I'm assuming that dates from the past are considered invalid input.
         */
        if( daysLeft < 0 ) {
            throw Time2HarvestControllerException("You missed harvest by " + daysLeft.absoluteValue + " days")
        }

        return ApiResponse(ApiResponseStatus.OK, Time2Harvest(to, daysLeft))
    }


}