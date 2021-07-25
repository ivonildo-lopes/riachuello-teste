package com.riachuello.teste.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="produtos")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {

	@Id
	@GeneratedValue
	private Long codigo;
	private String sku;
	private String titulo;
	private String descricao;
	private String dimensao;
	private Integer estoque;
	private BigDecimal preco;

	@ManyToMany
	@JoinTable(
			name = "lojas",
			joinColumns = @JoinColumn(name = "codigo_produto"),
			inverseJoinColumns = @JoinColumn(name = "codigo_localidade"))
	private List<Localidade> localidades;

	@JsonIgnore
	public List<Localidade> addLocalida(String codigo_localidade){
		List<Localidade> localidades = new ArrayList<>();
		Localidade localidade = new Localidade();
		localidade.setCodigo(codigo_localidade);
		localidades.add(localidade);
		return localidades;
	}
}
