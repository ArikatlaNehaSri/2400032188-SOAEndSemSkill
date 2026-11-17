package com.example.tourist.service;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
@Service
public class TokenService {
 private final ConcurrentMap<String, Boolean> tokens = new ConcurrentHashMap<>();
 public String generateToken() {
  String token = UUID.randomUUID().toString();
  tokens.put(token, true);
  return token;
 }
 public boolean isValid(String token) { return token != null && tokens.containsKey(token); }
}
