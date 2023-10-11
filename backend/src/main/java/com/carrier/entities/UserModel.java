package com.carrier.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

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
	@NotNull
	private Long id;
	@NotNull
	private String name;
	@NotNull
	@OneToMany(mappedBy = "address_id",cascade = CascadeType.ALL)
	private Set<Address> address;
	@NotNull
	private String mobile;
	@NotNull
	private String email;
	@NotNull
	private String password;
	
	
	

}
