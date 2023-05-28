package com.moblie.programming.assignment.type

class Common {
    companion object {
        const val API_HOST = "https://raw.githubusercontent.com/0xlethe/2023_moblie_programming_assignment/main"
        const val API_LIST = "${API_HOST}/docs/certification.json"
        const val DUMMY_IMAGE = "http://placeimg.com/640/480/tech"

    }

    object DUMMY_CERTIFICATE {
        const val NAME = "dummy name"
        const val ORGANIZATION = "dummy organization"
        const val IMAGE = "http://placeimg.com/640/480/tech"
        val AMOUNT = arrayOf(Pair("필기", 10000), Pair("실기", 20000))
        const val LINK = ""
        const val INFORMATION = "dummy Information!!"
    }
}