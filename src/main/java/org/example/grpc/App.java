package org.example.grpc;

import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.GreetingServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {
        ManagedChannel channel = ManagedChannelBuilder
                .forTarget("localhost:8081")
                .usePlaintext()
                .build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub =
                GreetingServiceGrpc.newBlockingStub(channel);

        GreetingServiceOuterClass.HelloRequest request = GreetingServiceOuterClass.HelloRequest
                .newBuilder().setName("Nursultan")
                .build();

        GreetingServiceOuterClass.HelloResponse response = stub.greeting(request);
        System.out.println(response);
        channel.shutdownNow();

        System.out.println("request sending ...");

    }
}
