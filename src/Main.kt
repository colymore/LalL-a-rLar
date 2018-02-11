class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            getGrammarRules(emptyList())
        }
    }
}

private fun getGrammarRules(args: List<String>) {
    val rules = listOf(
            Pair("A", "a A"),
            Pair("A", "B"),
            Pair("B", "b"),
            Pair("B", "x"),
            Pair("B", "D"),
            Pair("D", "c"),
            Pair("D", "λ")
    )
    System.out.println("Rules :" + rules)
    System.out.println(parseGrammar(rules))

}

