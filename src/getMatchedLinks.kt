fun extractHTTPLink(input: String): String? {
    val pattern  = Regex("https?:\\/\\/[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")
    val HTTPLink = pattern.find(input = input, startIndex = 7)

    return HTTPLink?.value
}

fun getMainLinks(input: CharSequence): List<String?> {
    val pattern       = Regex("<a href=\"(https?):\\/\\/[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]\" ping=\"\\/url\\?[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]\">")
    val matchResults  = pattern.findAll(input)
    val resultsLink    = matchResults.map() { extractHTTPLink(it.value) }
    
    return resultsLink.toList()
}
