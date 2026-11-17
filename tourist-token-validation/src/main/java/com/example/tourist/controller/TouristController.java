package com.example.tourist.controller;
import com.example.tourist.entity.Tourist;
import com.example.tourist.service.TokenService;
import com.example.tourist.service.TouristService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController
@RequestMapping("/api/tourist")
public class TouristController {
 private final TouristService service;
 private final TokenService tokenService;
 public TouristController(TouristService service, TokenService tokenService) {
  this.service=service; this.tokenService=tokenService;
 }
 @PutMapping("/{id}")
 public ResponseEntity<?> updateTourist(@PathVariable Long id,
   @RequestHeader(value="Token", required=false) String token,
   @RequestBody Tourist tourist) {
  // Validate token BEFORE any database mutation.
  if (!tokenService.isValid(token)) {
   return ResponseEntity.status(HttpStatus.FORBIDDEN)
    .body(Map.of("error","Invalid or missing token"));
  }
  return ResponseEntity.ok(service.updateTourist(id,tourist));
 }
 @GetMapping("/{id}")
 public Tourist getTourist(@PathVariable Long id) { return service.getTourist(id); }
}
