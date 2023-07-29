package com.railworldindia.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railworldindia.Entites.Address;
import com.railworldindia.Entites.Employee;

public interface AddressRepository extends JpaRepository<Address, Integer>{

	Address save(Employee employee);

}
