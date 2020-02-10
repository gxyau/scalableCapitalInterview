/*
    Web crawler for Scalable Capital Interview
*/

fun main() {
    println("What would you like to search?")
    // Prompt user input and convert to Google search URL
    val userInput    = readLine()?.split(" ")?.joinToString("+")
    val searchTerm   = "https://www.google.com/search?q=$userInput"
    // Scraping the main result URL's
    println("Getting main result URL from $searchTerm")
    val searchResult = getWebpageHTML(searchTerm)
    val searchLinks  = getMainLinks(searchResult)
    println(searchLinks)
    // Downloading the websites' HTML as string
    val websitesHTML = searchLinks.map() { getWebpageHTML(it) }
    val numberOfWebsites = websitesHTML.size
    println("Successfully downloaded from $numberOfWebsites pages")
}
