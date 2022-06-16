package com.example.bookhub.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {
    @Insert
    fun insertBook(bookEntity: BookEntity)

    @Delete
    fun deleteBook(bookEntity: BookEntity)

    @Query("Select * from books")
    fun getAllBooks():List<BookEntity>

    @Query("Select * from books where book_id=:bookId")
     fun getBookBYId(bookId:String):BookEntity
}