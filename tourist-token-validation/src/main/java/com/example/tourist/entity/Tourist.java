package com.example.tourist.entity;
import jakarta.persistence.*;
@Entity
public class Tourist {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String name;
 private String visitedDestination;
 private String contactDetails;
 public Tourist() {}
 public Tourist(String name, String visitedDestination, String contactDetails) {
  this.name=name; this.visitedDestination=visitedDestination; this.contactDetails=contactDetails;
 }
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getName(){return name;} public void setName(String name){this.name=name;}
 public String getVisitedDestination(){return visitedDestination;} public void setVisitedDestination(String v){this.visitedDestination=v;}
 public String getContactDetails(){return contactDetails;} public void setContactDetails(String c){this.contactDetails=c;}
}
