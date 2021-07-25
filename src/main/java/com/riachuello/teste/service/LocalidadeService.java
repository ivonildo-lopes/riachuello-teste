package com.riachuello.teste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riachuello.teste.entity.Localidade;
import com.riachuello.teste.dao.LocalidadeDao;

@Service
public class LocalidadeService {
	
	@Autowired
	private LocalidadeDao repository;

	public Localidade cadastrar(Localidade localidadeRequest) {
		
		return repository.save(localidadeRequest);
	}

	public List<Localidade> findAll() {
		return repository.findAll();
	}

}
