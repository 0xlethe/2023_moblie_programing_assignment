package com.moblie.programming.assignment.type
import java.io.Serializable

data class CertificateAmount(val key: String, val amount: Int): Serializable {}

data class Certificate(
    val id: Int,
    val name: String = Common.DUMMY_CERTIFICATE.NAME,
    var organization: String = Common.DUMMY_CERTIFICATE.ORGANIZATION,
    var imageLink: String = Common.DUMMY_CERTIFICATE.IMAGE,
    var amount: List<CertificateAmount> = Common.DUMMY_CERTIFICATE.AMOUNT,
    var link: String = Common.DUMMY_CERTIFICATE.LINK,
    var information: String = Common.DUMMY_CERTIFICATE.INFORMATION,
    var isFav: Boolean = false
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

    fun isValid(): Boolean {
        if (this.name?.isEmpty()) return false
        if (this.organization?.isEmpty()) return false
        if (this.imageLink?.isEmpty()) return false
        if (this.link?.isEmpty()) return false
        if (this.information?.isEmpty()) return false
        if (this.amount?.isEmpty()) return false

        return true
    }

    override fun equals(other: Any?): Boolean {
        val temp = other as Certificate
        return this.name.equals(temp.name) && this.organization.equals(temp.organization)
    }
}