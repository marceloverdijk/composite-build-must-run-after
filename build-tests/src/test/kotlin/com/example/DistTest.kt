package com.example

import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals

class DistTest {

//    @Test
//    fun testDummy() {
//        assertEquals("foo", "bar")
//    }

    @Test
    fun testDistFile() {
        // Assert dist file exists
        val distFile = File("../build/data/dist.txt")
        assert(distFile.exists()) { "Expected file does not exist: ${distFile.absolutePath}" }

        val expectedContent = content();
        val actualContent = distFile.readText().trim()

        // Assert content is as expected
        assertEquals(expectedContent, actualContent, "File content does not match expected value")
    }
}
