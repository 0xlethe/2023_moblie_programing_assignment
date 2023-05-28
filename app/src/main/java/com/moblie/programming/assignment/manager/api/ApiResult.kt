package com.moblie.programming.assignment.manager.api

import com.moblie.programming.assignment.type.Certificate

class ApiData {
    var length: Int = 0
    lateinit var certification: List<Certificate>
}

class ApiResult {
    lateinit var result: String
    lateinit var data: ApiData
}