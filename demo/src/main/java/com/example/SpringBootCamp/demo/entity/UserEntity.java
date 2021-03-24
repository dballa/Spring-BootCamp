package com.example.SpringBootCamp.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@ToString
@NamedQuery(name = "User.findAll", query = "SELECT user FROM UserEntity user ")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, name = "first_name", length = 50)
	private String firstName;

	@Column(nullable = false, name = "last_name", length = 50)
	private String lastName;
	
	@Column(nullable = false, name = "age")
	private int age;
	
	@ManyToOne
	@JoinColumn(name="subscriptionid", referencedColumnName="id")
	private SubscriptionEntity subscription;
}
