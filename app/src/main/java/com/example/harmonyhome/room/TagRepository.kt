package com.example.harmonyhome.room

import kotlinx.coroutines.flow.Flow

interface TagRepository {

    fun getAllTagsStream(): Flow<List<Tag>>

    fun getTagStream(id: Int): Flow<Tag?>

    suspend fun insertTag(tag: Tag)

    suspend fun deleteTag(tag: Tag)

}