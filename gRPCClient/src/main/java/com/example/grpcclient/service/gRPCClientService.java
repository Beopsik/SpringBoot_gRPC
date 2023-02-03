package com.example.grpcclient.service;

import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.chb.examples.lib.HelloReply;
import org.chb.examples.lib.HelloRequest;
import org.chb.examples.lib.SimpleGrpc;
import org.springframework.stereotype.Service;

@Service
public class gRPCClientService {

    @GrpcClient("test")
    private SimpleGrpc.SimpleBlockingStub simpleBlockingStub;

    public String sendMessage(final String name) {
        try {
            HelloReply response = this.simpleBlockingStub.sayHello(HelloRequest.newBuilder().setName(name).build());
            return response.getMessage();
        } catch (StatusRuntimeException e) {
            return "Failed with " + e.getStatus().getCode().name();
        }
    }
}
