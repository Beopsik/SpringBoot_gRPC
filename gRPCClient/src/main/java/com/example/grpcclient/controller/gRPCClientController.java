package com.example.grpcclient.controller;

import com.example.grpcclient.service.gRPCClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class gRPCClientController {
    private final gRPCClientService gRPCClientService;

    @GetMapping("/test")
    public String printMessage() {
        return gRPCClientService.sendMessage("test");
    }
}
