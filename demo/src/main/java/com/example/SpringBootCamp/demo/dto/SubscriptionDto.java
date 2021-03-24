package com.example.SpringBootCamp.demo.dto;

import javax.persistence.Column;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SubscriptionDto {

	private Long id;

	private String name;

	private boolean active;

}
