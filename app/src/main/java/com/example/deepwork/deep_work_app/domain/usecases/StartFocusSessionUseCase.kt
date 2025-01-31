package com.example.deepwork.deep_work_app.domain.usecases

import com.example.deepwork.deep_work_app.data.local.entities.Sessions
import com.example.deepwork.deep_work_app.domain.repository.SessionsRepository

class StartFocusSessionUseCase(private val sessionsRepository: SessionsRepository) {
    suspend operator fun invoke(session: Sessions) = sessionsRepository.insertSession(session)

}