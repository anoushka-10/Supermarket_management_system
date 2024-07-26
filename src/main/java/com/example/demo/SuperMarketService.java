package com.example.demo;

import java.util.List;
import java.util.Optional;

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


	public void deleteItem(long id) {
		repo.deleteById(id);
		
	}


	public List<SuperMarket> getAllItems() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}


	public SuperMarket findById(Long id) {
        Optional<SuperMarket> result = repo.findById(id);
        return result.orElse(null); // Return the entity or null if not found
    }


}
