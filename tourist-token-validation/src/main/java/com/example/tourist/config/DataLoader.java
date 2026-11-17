package com.example.tourist.config;
import com.example.tourist.entity.Tourist;
import com.example.tourist.repository.TouristRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
@Configuration
public class DataLoader {
 @Bean CommandLineRunner sampleData(TouristRepository repository) {
  return args -> { if (repository.count()==0)
   repository.save(new Tourist("Rahul","Goa","9876543210")); };
 }
}
