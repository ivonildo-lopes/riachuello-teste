package com.riachuello.teste.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="localidades")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Localidade {
	
	@Id
	private String codigo;
	private String tipo;

	@JsonIgnore
	@ManyToMany(mappedBy = "localidades")
	private List<Produto> produtos;
}
