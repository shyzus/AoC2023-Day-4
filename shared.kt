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