package com.kilvish.autoassign.utils

object Utils {

    val CARLOAN = "CARLOAN"
    val EDUCATIONLOAN = "EDUCATIONLOAN"
    val HOMELOAN = "HOMELOAN"

    val STRING_CHARACTERS = ('a'..'z').toList().toTypedArray()
    val INT_CHARACTERS = ('0'..'9').toList().toTypedArray()

    fun getRandomString(length: Int, stringCharacters: Array<Char>)
            =  (1..length).map { stringCharacters.random() }.joinToString("")

}