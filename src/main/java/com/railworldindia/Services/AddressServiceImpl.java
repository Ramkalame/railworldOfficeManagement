package com.railworldindia.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railworldindia.Entites.Address;
import com.railworldindia.Entites.Employee;
import com.railworldindia.Repositories.AddressRepository;
import com.railworldindia.Repositories.EmployeeRepository;
@Service
public class AddressServiceImpl implements AddressService {
	
	private final AddressRepository addressRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
	
	@Override
	public Address getAddressById(int id) {
		// TODO Auto-generated method stub
		return addressRepository.findById(id).orElse(null);
	}

	@Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

	
	@Override
    public void deleteAddress(int id) {
        addressRepository.deleteById(id);
    }

	@Override
	public Address addressRegister(Address address) {
		
		return addressRepository.save(address);
	}}

//
//    public Address addAddressDetails( Address address) {
//        
//            // Create a new Address object with the details from the DTO
//            Address newAddress = new Address();
//            newAddress.setStreet(address.getStreet());
//            newAddress.setCity(address.getCity());
//            newAddress.setState(address.getState());
//            newAddress.setPinCode(address.getPinCode());
//
//            // Add the new address to the employee's address list
//            List<Address> addressList = employee.getAddresslist();
//            addressList.add(newAddress);
	
	  //     employee.setAddresslist(addressList);
//
//            // Save the updated employee (including the new address) to the database
//            return addressRepository.save(employee);
//        } else {
//            return null;
//        }
//    }
//	
//    public Address updateAddressDetails(int id, Address address) {
//        // Find the employee from the database
//        Employee employee = employeeRepository.findById(id).orElse(null);
//
//        if (employee != null) {
//            // Create a new Address object with the details from the DTO
//            Address newAddress = new Address();
//            newAddress.setStreet(address.getStreet());
//            newAddress.setCity(address.getCity());
//            newAddress.setState(address.getState());
//            newAddress.setPinCode(address.getPinCode());
//
//            // Add the new address to the employee's address list
//            List<Address> addressList = employee.getAddresslist();
//            addressList.add(newAddress);
//
//            // Save the updated employee (including the new address) to the database
//            return addressRepository.save(employee);
//        } else {
//            return null;
//        }
//    }
//
//}
