package com.riachuello.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riachuello.teste.entity.Localidade;
import com.riachuello.teste.service.LocalidadeService;


@RestController
@RequestMapping(value = "localidades")
public class LocalidadeController {

	@Autowired
	private LocalidadeService localidadeService;
	
	@PostMapping(path = "/save")
	public Localidade cadastrar(@RequestBody Localidade localidadeRequest) {
		
		Localidade localidade = localidadeService.cadastrar(localidadeRequest);
		
		return localidade;
	}
	
	@GetMapping(path = "/all")
	public List<Localidade> findAll() {
		return localidadeService.findAll();
	}
}
