package com.moblie.programming.assignment.type
import java.io.Serializable

data class CertificateAmount(val key: String, val amount: Int): Serializable {}

data class Certificate(
    val id: Int,
    val name: String,
    var organization: String,
    var imageLink: String,
    var amount: List<CertificateAmount>,
    var link: String,
    var infomation: String
): Serializable {
    constructor() : this(
        -1,
        Common.DUMMY_CERTIFICATE.NAME,
        Common.DUMMY_CERTIFICATE.ORGANIZATION,
        Common.DUMMY_CERTIFICATE.IMAGE,
        Common.DUMMY_CERTIFICATE.AMOUNT,
        Common.DUMMY_CERTIFICATE.LINK,
        Common.DUMMY_CERTIFICATE.INFORMATION
    )
    constructor(name: String, organization: String) : this(
        -1,
        name,
        organization,
        Common.DUMMY_CERTIFICATE.IMAGE,
        Common.DUMMY_CERTIFICATE.AMOUNT,
        Common.DUMMY_CERTIFICATE.LINK,
        Common.DUMMY_CERTIFICATE.INFORMATION
    )
}