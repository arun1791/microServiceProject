package com.userservice.com.enities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="micro_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	@Id
	@Column(name="ID")
	private String userId;
	@Column(name="userName")
	private String name;
	@Column(name="userEmail")
	private String email;
	@Column(name="about")
	private String about;
	//other user prop that u want

	@Transient
	private List<Rating> rating =new ArrayList<>();
	

}
