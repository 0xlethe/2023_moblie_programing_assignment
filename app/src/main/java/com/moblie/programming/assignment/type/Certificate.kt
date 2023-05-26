package com.moblie.programming.assignment.type
import java.io.Serializable

data class Certificate(
    val id: Int,
    val name: String,
    var organization: String,
    var imageLink: String,
    var examAmount: Int,
    var link: String,
    var infomation: String
): Serializable {
    constructor() : this(-1, "dummy name:", "dummy organization", "", 100000, "", "dummy Infomation")
    constructor(name: String, organization: String) : this(-1, name, organization, "", 100000, "", "dummy Infomation")
}