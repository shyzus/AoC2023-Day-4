import java.io.File

fun main() {
    File("input.txt").useLines { lines ->

        var totalPoints = 0

        lines.forEach { line ->
            val numbers = line.split(':')[1].split('|')
            val winningNumbers = parseNumbers(numbers[0])
            val myNumbers = parseNumbers(numbers[1])

            var cardPoints = 0

            myNumbers.forEach { myNumber ->
                if (winningNumbers.contains(myNumber)) {
                    if (cardPoints == 0) {
                        cardPoints += 1
                    } else {
                        cardPoints *= 2
                    }
                }
            }

            totalPoints += cardPoints
        }

    }
}

fun parseNumbers(line: String) : ArrayList<Int> {
    val sb = StringBuilder()
    val result = ArrayList<Int>()

    line.trim().forEach {
        if (it.isWhitespace()) {

            if (sb.isNotEmpty()) {
                result.add(sb.toString().toInt())
                sb.clear()
            }

        } else {
            sb.append(it)
        }
    }

    if (sb.isNotEmpty()) {
        result.add(sb.toString().toInt())
        sb.clear()
    }

    return result
}