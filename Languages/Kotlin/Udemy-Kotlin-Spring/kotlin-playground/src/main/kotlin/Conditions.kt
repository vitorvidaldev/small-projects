fun main() {
    val position = 1

    val medal = when (position) {
        1 -> "Gold"
        2 -> "Silver"
        3 -> "Bronze"
        else -> "No medal"
    }

    print(medal)
}