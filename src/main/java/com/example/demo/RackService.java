package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RackService {
    @Autowired
    private RackRepository rackRepository;

    public List<Rack> getAllRacks() {
        return rackRepository.findAll();
    }

	public RackService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RackService(RackRepository rackRepository) {
		super();
		this.rackRepository = rackRepository;
	}

    // Other methods to manage racks
  

 

}