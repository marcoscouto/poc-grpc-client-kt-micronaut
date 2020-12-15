package com.marcoscouto.client

import com.marcoscouto.TaskServiceGrpc
import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel

@Factory
class TaskStub {

    @Bean
    fun stub (@GrpcChannel("task") channel: ManagedChannel) : TaskServiceGrpc.TaskServiceBlockingStub {
        return TaskServiceGrpc.newBlockingStub(channel)
    }

}