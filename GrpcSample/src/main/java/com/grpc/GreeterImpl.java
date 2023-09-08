package com.grpc;

import io.grpc.stub.StreamObserver;

public class GreeterImpl extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(Request request, StreamObserver<Response> responseObserver) {
        String responseText = "Hello, " + request.getName();

        Response response = Response.newBuilder()
                .setGreeting(responseText)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void sayGoodMorning(Request request, StreamObserver<Response> responseObserver) {
        super.sayGoodMorning(request, responseObserver);
    }
}
