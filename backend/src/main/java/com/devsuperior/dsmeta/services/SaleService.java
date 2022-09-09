package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

//@Service estou registrando o SalesServise como compomente do sistema.
@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	//metodo para buscras as vendas 
	
	public Page<Sale> findSales(String minDate,String maxDate,Pageable pageable) {
		
		//Criar ma varia com a data atual
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		return repository.findSales(min, max, pageable);	
	}

}
