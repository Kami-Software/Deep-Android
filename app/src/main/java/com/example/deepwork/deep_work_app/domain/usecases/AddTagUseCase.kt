package com.example.deepwork.deep_work_app.domain.usecases

import com.example.deepwork.deep_work_app.data.local.entities.Tags
import com.example.deepwork.deep_work_app.domain.repository.TagsRepository

class AddTagUseCase(private val tagsRepository: TagsRepository){
    suspend operator fun invoke(tags: Tags){
            tagsRepository.insertTag(tags)
    }
}