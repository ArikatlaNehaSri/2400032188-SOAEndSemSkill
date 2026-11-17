package com.example.tourist.controller;
import com.example.tourist.service.TokenService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController
@RequestMapping("/api/auth")
public class AuthController {
 private final TokenService tokenService;
 public AuthController(TokenService tokenService) { this.tokenService=tokenService; }
 @PostMapping("/token")
 public Map<String,String> generateToken() {
  return Map.of("message","Token generated successfully","token",tokenService.generateToken());
 }
}
