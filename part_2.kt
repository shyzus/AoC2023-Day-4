import java.io.File

fun main() {
    File("input.txt").useLines { lines ->
        val cards = ArrayList<Pair<ArrayList<Int>, ArrayList<Int>>>()
        lines.forEach { line ->
            val numbers = line.split(':')[1].split('|')
            cards.add(Pair(parseNumbers(numbers[0]), parseNumbers(numbers[1])))
        }

        val copies = HashMap<Int, ArrayList<Pair<ArrayList<Int>, ArrayList<Int>>>>()

        cards.forEachIndexed { idx, it ->
            val newList = ArrayList<Pair<ArrayList<Int>, ArrayList<Int>>>()
            newList.add(it)
            copies[idx] = newList
        }

        copies.forEach { (idx, listOfCards) ->
            var matches = 0

            val card = listOfCards.first()

            card.second.forEach { number ->
                if (card.first.contains(number)) {
                    matches += 1
                }
            }

            listOfCards.forEach { _ ->
                for (i in idx+1..(idx+matches)) {

                    if (copies.containsKey(i)) {
                        copies[i]?.addAll(listOf(cards[i].copy()))
                    }
                }
            }


        }

        var result = 0

        copies.forEach { (_, listOfCards) ->
            result += listOfCards.size
        }
        println(result)


    }
}