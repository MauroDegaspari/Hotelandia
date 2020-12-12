package com.hotelandia.com.hotelandia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor // abistração do get sets
@Data
@Entity(name="DadosHotel")
@Table(name="hotelandia")
public class DadosHotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private int capacidade;
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private String cep;
	private int n;
	
}
