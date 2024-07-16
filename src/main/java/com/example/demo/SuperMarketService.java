package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SuperMarketService {
	private SuperMarketRepository repo;
	
	

	public SuperMarketService(SuperMarketRepository repo) {
		super();
		this.repo = repo;
	}


	public List<SuperMarket> retrieveAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
		
	}


	public void saveItem(SuperMarket market) {
		repo.save(market);
		
	}


	public void deleteItem(int id) {
		repo.deleteById(id);
		
	}


	public List<SuperMarket> getAllItems() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}


}
