package com.example.tourist.service;
import com.example.tourist.entity.Tourist;
import com.example.tourist.repository.TouristRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
@Service
public class TouristService {
 private final TouristRepository repository;
 public TouristService(TouristRepository repository) { this.repository=repository; }
 public Tourist updateTourist(Long id, Tourist data) {
  Tourist old = repository.findById(id).orElseThrow(() ->
   new ResponseStatusException(HttpStatus.NOT_FOUND, "Tourist not found"));
  old.setName(data.getName());
  old.setVisitedDestination(data.getVisitedDestination());
  old.setContactDetails(data.getContactDetails());
  return repository.save(old);
 }
 public Tourist getTourist(Long id) {
  return repository.findById(id).orElseThrow(() ->
   new ResponseStatusException(HttpStatus.NOT_FOUND, "Tourist not found"));
 }
}
