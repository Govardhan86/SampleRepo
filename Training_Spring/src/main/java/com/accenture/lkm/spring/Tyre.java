package com.accenture.lkm.spring;

import org.springframework.stereotype.Component;

@Component
public class Tyre {
	
	private String brand="MRF";

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void showBrand()
	{
		System.out.println("Tyre brand: "+brand);
	}
	
	
}
