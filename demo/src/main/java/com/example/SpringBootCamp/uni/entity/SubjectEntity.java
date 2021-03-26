package com.example.SpringBootCamp.uni.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "subject", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@ToString
@NamedQuery(name = "subject.findAll", query = "SELECT subject FROM SubjectEntity subject ")
public class SubjectEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, name = "name", length = 500)
	private String name;

	@Column(nullable = false, name = "active")
	private boolean active;

	@Column(nullable = false, name = "credits_cfu")
	private Double creditsCfu;

	@Column(name = "semester")
	private Long semester;

	@Column(name = "totalHours")
	private Double total_hours;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="professor_id" , referencedColumnName = "id")
	private ProfessorEntity professor;

}
