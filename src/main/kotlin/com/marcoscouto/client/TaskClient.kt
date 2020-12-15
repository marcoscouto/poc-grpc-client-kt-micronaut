package com.marcoscouto.client

import com.marcoscouto.Task
import com.marcoscouto.TaskFindByIdRequest
import com.marcoscouto.TaskServiceGrpc
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class TaskClient(val stub: TaskServiceGrpc.TaskServiceBlockingStub) {

    val log = LoggerFactory.getLogger(TaskClient::class.java)

    fun findById(request: TaskFindByIdRequest): Task {
        log.info("[TASK] Request task in another service, id ${request.id}")
        return stub.findById(request)
    }
}