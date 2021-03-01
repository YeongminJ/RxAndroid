package com.example.myretrofit

import com.example.myretrofit.MaxSum.findMaxSum
import org.junit.Test
import java.util.*


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        assertEquals(4, 2 + 2)
        val list: List<Int> = Arrays.asList(5, 9, 7, 11)
        println(findMaxSum(list))

//        println(RemoveRepetition.transform("abbcbbb"))

    }
}

class Account {

}