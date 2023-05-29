package com.moblie.programming.assignment.manager

import com.moblie.programming.assignment.type.Certificate

class CertificateManager {
    companion object {
        var data: List<Certificate> = listOf()

        fun updateFav(certificate: Certificate, isFav: Boolean? = null): Boolean {
            var result: Boolean = false
            data.map {
                if (it == certificate) {
                    it.isFav = isFav ?: !it.isFav
                    result = it.isFav
                }
            }
            return result
        }

        fun updateAllFav(isFav: Boolean) {
            data.map {
                it.isFav = isFav
            }
        }

    }
}