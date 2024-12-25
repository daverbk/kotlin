package games.gameOfFifteen

import java.util.Collections.swap

interface GameOfFifteenInitializer {
    /*
     * Even permutation of numbers 1..15
     * used to initialized the first 15 cells on a board.
     * The last cell is empty.
     */
    val initialPermutation: List<Int>
}

class RandomGameInitializer : GameOfFifteenInitializer {
    /*
     * Generate a random permutation from 1 to 15.
     * `shuffled()` function might be helpful.
     * If the permutation is not even, make it even (for instance,
     * by swapping two numbers).
     */
    override val initialPermutation by lazy {
        (1..15).shuffled().apply {
            if (isEven(this)) return@apply
            val firstOddIndex = indexOfFirst { it % 2 != 0 }
            val secondOddIndex = indexOfFirst { it % 2 != 0 && it != firstOddIndex }
            swap(this, firstOddIndex, secondOddIndex)
        }
    }
}

