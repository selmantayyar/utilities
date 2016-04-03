package com.utils.samples.hibernate.model;

import java.util.Collection;

public class ProxyUserDetails extends UserDetails {
	
    public Collection<Address> getListOfAddresses() {
    	System.out.println("getting list for child");
    	
		return null;
	}

}
