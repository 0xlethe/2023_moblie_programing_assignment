package com.moblie.programming.assignment.type

data class Certificate(val name: String, val company: String) {
    constructor() : this("dummy name:", "dummy company")
}