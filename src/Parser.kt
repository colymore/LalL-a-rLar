fun parseGrammar(grammar: List<Pair<String, String>>) = getFirsts(grammar)

fun getFirsts(grammar: List<Pair<String, String>>): Map<String, List<String>> =
        grammar.groupBy { it.first }
                .mapValues { it.value.map { it.second } }
                .mapValues {
                    it.value.map {
                        getFirsts(grammar.groupBy { it.first }.mapValues { it.value.map { it.second } }, it)
                    }.flatten()
                }

fun getFollows(grammar: List<Pair<String, String>>, firsts: Map<String, List<String>>) {

}

private fun getFirsts(mapByRules: Map<String, List<String>>, it: String): Collection<String> {
    return when {
        !mapByRules.containsKey(it.substringBefore(" ")) -> setOf(it.substringBefore(" "))
        else -> mapByRules
                .filterKeys { key -> key == it }
                .values
                .flatten()
                .map {
                    when {
                        !mapByRules.containsKey(it.substringBefore(" ")) -> listOf(it)
                        else -> getFirsts(mapByRules, it)
                    }
                }.flatten()
    }
}







