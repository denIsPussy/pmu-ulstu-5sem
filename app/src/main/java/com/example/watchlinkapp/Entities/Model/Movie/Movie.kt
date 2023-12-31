package com.example.watchlinkapp.Entities.Model.Movie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val movieId: Int?,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "releaseYear")
    val releaseYear: Int,
    @ColumnInfo(name = "duration")
    val duration: Double,
    @ColumnInfo(name = "rating")
    val rating: Double,
    @ColumnInfo(name = "synopsis")
    val synopsis: String,
    @ColumnInfo(name = "director")
    val director: String,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB, name = "image")
    val image: ByteArray? = null,
    val phone: String,
    val email: String
) {

    @Ignore
    constructor(
        title: String,
        releaseYear: Int,
        duration: Double,
        rating: Double,
        synopsis: String,
        director: String,
        image: ByteArray,
        phone: String,
        email: String
    ) : this(null, title, releaseYear, duration, rating, synopsis, director, image, phone, email)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Movie
        if (movieId != other.movieId) return false
        return true
    }

    override fun hashCode(): Int {
        return movieId ?: -1
    }
}
