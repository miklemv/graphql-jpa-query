package com.introproventures.graphql.jpa.query.mutations.model.book;

import com.introproventures.graphql.jpa.query.mutations.annotation.GraphQLWriteEntityForRole;
import com.introproventures.graphql.jpa.query.mutations.annotation.GraphQLWriteType;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@GraphQLWriteEntityForRole(value = {"user"}, operations = {GraphQLWriteType.ALL})
public class Book {
	@Id
	Long id;

	String title;

	@ManyToOne(fetch=FetchType.LAZY)
	Author author;

	@Enumerated(EnumType.STRING)
	Genre genre;

	@ManyToMany(mappedBy = "books", fetch = FetchType.EAGER/*, cascade =  CascadeType.ALL*/)
	private Set<PublishingHouse> houses = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Set<PublishingHouse> getHouses() {
		return houses;
	}

	public void setHouses(Set<PublishingHouse> houses) {
        this.houses.clear();
		this.houses.addAll(houses);
	}
}