package com.javaee.web.starter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Data
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  String name;

  @Column(name = "isbn")
  String isbn;

  @Column(name = "author")
  String author;

  @ManyToMany(mappedBy = "likedBooks")
  @JsonIgnore
  private Set<User> usersLikes;

  public Book(String name, String author, String isbn) {
    this.name = name;
    this.author = author;
    this.isbn = isbn;
  }
}
