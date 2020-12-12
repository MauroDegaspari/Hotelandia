package com.hotelandia.com.hotelandia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelandia.com.hotelandia.model.DadosHotel;
import com.hotelandia.com.hotelandia.repository.HotelRepository;

@RestController
@RequestMapping({"/hotel"})
public class HotelController {

	@Autowired
	private HotelRepository repository;
	
	
	@GetMapping
	public List<?> findAll() {
		return repository.findAll();	
	}

	@GetMapping(value = "{id}")
	public ResponseEntity findById(@PathVariable int id){
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	@PostMapping
	public DadosHotel create(@RequestBody DadosHotel dados) {
		return repository.save(dados);
	}
	
	@PutMapping(value ="{id}")
	public ResponseEntity update(@PathVariable("id") int id, @RequestBody DadosHotel dados ) {
		return repository.findById(id).map(record -> {
			record.setNome(dados.getNome());
			record.setCapacidade(dados.getCapacidade());
			record.setCep(dados.getCep());
			record.setEstado(dados.getEstado());
			record.setCidade(dados.getCidade());
			record.setBairro(dados.getBairro());
			record.setRua(dados.getRua());
			record.setN(dados.getN());
			DadosHotel update = repository.save(record);
			return ResponseEntity.ok().body(update);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable int id){
		return repository.findById(id).map(record -> {
							repository.deleteById(id);
							return ResponseEntity.ok().build();
							}).orElse(ResponseEntity.notFound().build());
	}


}
