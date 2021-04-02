package com.academy.monika.restapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "professor", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@ToString
@NamedQuery(name = "professor.findAll", query = "SELECT professor FROM ProfessorEntity professor ")
public class ProfessorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, name = "first_name", length = 50)
	private String firstName;

	@Column(nullable = false, name = "last_name", length = 50)
	private String lastName;

}
