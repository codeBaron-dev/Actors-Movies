package com.codebaron.netflixclone

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val data = "/name/nm0913587/"
        val startIndex = 6
        val endIndex = 15
        val subString = data.subSequence(startIndex, endIndex)
        println("HERE ==> $subString")
        assertEquals(4, 2 + 2)
    }
}