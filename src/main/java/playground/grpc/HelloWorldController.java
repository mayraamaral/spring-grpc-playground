package playground.grpc;

import io.grpc.ManagedChannel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloWorldController {
    private final HelloWorldServiceGrpc.HelloWorldServiceBlockingStub stub;

    public HelloWorldController(ManagedChannel channel) {
        this.stub = HelloWorldServiceGrpc.newBlockingStub(channel);
    }

    @GetMapping("/greet")
    public ResponseEntity<?> getGreeting(@RequestParam String name) {
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply response = stub.greet(request);

        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("greeting", response.getMessage());

        return ResponseEntity.ok().body(responseBody);
    }
}
