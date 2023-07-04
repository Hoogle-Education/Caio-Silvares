package com.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new GreeterImpl())
                .build();

        System.out.println("starting server...");
        server.start();
        System.out.println("server started");
        server.awaitTermination();
    }
}
