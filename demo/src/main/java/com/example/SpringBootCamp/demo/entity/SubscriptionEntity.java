package com.example.SpringBootCamp.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "subscriptions", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@ToString
@NamedQuery(name = "Subscriptions.findAll", query = "SELECT user FROM SubscriptionEntity sub ")
public class SubscriptionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, name = "name", length = 50)
	private String name;
	
	@Column(nullable = false, name = "active")
	private boolean active;

}
