package com.example.deepwork.deep_work_app.domain.usecases

import com.example.deepwork.deep_work_app.domain.repository.SessionsRepository

class GetAverageSessionDurationUseCase(private val sessionsRepository: SessionsRepository) {
    suspend operator fun invoke():Double{
        return sessionsRepository.getAverageSessionDuration()
    }
}