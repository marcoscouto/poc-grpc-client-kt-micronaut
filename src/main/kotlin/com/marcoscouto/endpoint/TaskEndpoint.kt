package com.marcoscouto.endpoint

import com.marcoscouto.Task
import com.marcoscouto.TaskFindByIdRequest
import com.marcoscouto.TaskServiceGrpcKt
import com.marcoscouto.client.TaskClient
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class TaskEndpoint(val client: TaskClient): TaskServiceGrpcKt.TaskServiceCoroutineImplBase()  {

    val log = LoggerFactory.getLogger(TaskEndpoint::class.java)

    override suspend fun findById(request: TaskFindByIdRequest): Task  {
        log.info("[TASK] Find task requested, id ${request.id}")
        val task = client.findById(request)
        log.info("[TASK] Task founded, id ${request.id}")
        return task
    }

}