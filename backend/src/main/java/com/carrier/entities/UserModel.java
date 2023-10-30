package com.carrier.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String name;
	@NotEmpty
	@OneToMany(mappedBy = "address_id",cascade = CascadeType.ALL)
	private Set<Address> address;
	@NotEmpty
	@Size(min = 10, max = 13)
	private String mobile;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String password;
	
	
	

}
