package com.devsuperior.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

//@Service estou registrando o SalesServise como compomente do sistema.
@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	//metodo para buscras as vendas 
	
	public List<Sale> findSales() {
		return repository.findAll();	
	}

}
