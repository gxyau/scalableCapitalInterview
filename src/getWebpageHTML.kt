import java.net.URL

fun getWebpageHTML(webpageString: String?): String {
    // Build connection and set 'User-Agent'
    val connection   = URL(webpageString).openConnection()
    connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.29 Safari/537.36");
    
    // Get Contents
    val inputStream  = connection.getInputStream()
    val contents     = inputStream.readAllBytes().toString(Charsets.UTF_8)

    inputStream.close()

    return contents
}

