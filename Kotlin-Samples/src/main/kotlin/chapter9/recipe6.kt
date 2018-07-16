package chapter9

/**
 * Chapter: Miscellaneous
 * Recipe:
 */

data class Song(val title: String)

data class Artist(val name: String)

typealias GrouppedSongs<T> = Map<T, List<Song>>

fun main(vararg args: String) {
    val songs: GrouppedSongs<Artist> =
            mapOf(
                    Artist("Bob Dylan") to
                            listOf(Song("Blowing In The Wind"),
                                   Song("To Fall in Love With You")),

                    Artist("Louis Armstrong") to
                            listOf(Song("What A Beautiful World"))
            )

    println("${getMostPopularArtist(songs)} is the most popular")
}

fun getMostPopularArtist(songs: GrouppedSongs<Artist>) =
    songs.toList().sortedByDescending {it.second.size }.first().first
