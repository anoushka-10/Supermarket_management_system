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
    public Rack findById(Long id) {
        return rackRepository.findById(id).orElse(null);
    }

	public void save(Rack rackn) {
		// TODO Auto-generated method stub
		rackRepository.save(rackn);
	}

    // Other methods to manage racks
  

 

}