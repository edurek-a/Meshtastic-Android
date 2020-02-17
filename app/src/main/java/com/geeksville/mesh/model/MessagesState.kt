package com.geeksville.mesh.model

import androidx.compose.mutableStateOf
import com.geeksville.android.Logging
import java.util.*

/**
 * the model object for a text message
 */
data class TextMessage(val from: String, val text: String, val date: Date = Date())


object MessagesState : Logging {
    val testTexts = listOf(
        TextMessage(
            "+16508675310",
            "I found the cache"
        ),
        TextMessage(
            "+16508675311",
            "Help! I've fallen and I can't get up."
        )
    )

    // If the following (unused otherwise) line is commented out, the IDE preview window works.
    // if left in the preview always renders as empty.
    val messages = mutableStateOf(testTexts, { a, b ->
        a.size == b.size // If the # of messages changes, consider it important for rerender
    })

    fun addMessage(m: TextMessage) {
        val l = messages.value.toMutableList()
        l.add(m)
        messages.value = l
    }
}