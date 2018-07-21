package chapter4

import chapter4.Recipe8.album
import chapter4.Recipe8.Track
import chapter4.Recipe8.getStartTime

/**
 * Chapter: Powerful Data Processing
 * Recipe: Folding and reducing data sets
 */
fun main(vararg args: String) {
    println(album.getStartTime(Track("10/10", 176)))
}

object Recipe8 {
    data class Track(val title: String, val durationInSeconds: Int)
    data class Album(val name: String, val tracks: List<Track>)

    val album = Album("Sunny side up", listOf(
            Track("10/10", 176),
            Track("Coming Up Easy", 292),
            Track("Growing Up Beside You", 191),
            Track("Candy", 303),
            Track("Tricks of the Trade", 151)
    ))

    fun Album.getStartTime(track: Track): Int {
        if (track !in tracks) throw IllegalArgumentException("Bad track")

        val index = tracks.indexOf(track)
        return tracks
                .take(index)
                .map { (_, duration) -> duration }
                .fold(0) {  acc, i -> acc + i }
    }
}
