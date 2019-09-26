package org.athenian.lanterna

import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import java.util.concurrent.SynchronousQueue
import kotlin.concurrent.thread

fun main() {

    val queue = SynchronousQueue<String>()

    thread {
        TerminalScreen(DefaultTerminalFactory().createTerminal())
            .apply {
                var xPos = 10
                var yPos = 10
                var currentStr = ""

                startScreen()

                loop@ while (true) {
                    clear()
                    val s = queue.take()
                    when (s) {
                        "j" -> yPos++
                        "k" -> yPos--
                        "h" -> xPos--
                        "l" -> xPos++
                        "q" -> break@loop
                        else -> currentStr = s
                    }
                    newTextGraphics().putString(xPos, yPos, currentStr)
                    refresh()
                }

                stopScreen()
            }
    }

    thread {
        while (true) {
            print(">> ")
            val s = readLine() ?: ""
            queue.put(s)
        }
    }
}
