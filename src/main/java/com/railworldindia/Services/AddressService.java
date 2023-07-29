package com.railworldindia.Services;

import com.railworldindia.Entites.Address;

public interface AddressService {
	
	 Address getAddressById(int id);
	 Address saveAddress(Address address);
	    void deleteAddress(int id);
	    
	 Address addressRegister(Address address);
	 



// public Address updateAddressDetails(int id, Address address);
}



