package com.moblie.programming.assignment.manager

import com.moblie.programming.assignment.type.Certificate

class CertificateManager {
    companion object {
        var data: List<Certificate> = listOf()

        fun updateFav(certificate: Certificate): Boolean {
            var result: Boolean = false
            data.map {
                if (it == certificate) {
                    it.isFav = !it.isFav
                    result = it.isFav
                }
            }
            return result
        }

    }
}