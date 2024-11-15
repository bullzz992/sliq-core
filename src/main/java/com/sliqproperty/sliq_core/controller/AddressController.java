package com.sliqproperty.sliq_core.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sliqproperty.sliq_core.model.Address;
import com.sliqproperty.sliq_core.service.AddressService;

@RestController
@RequestMapping("/Addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressService.saveAddress(address);
    }

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public Optional<Address> getAddressById(@PathVariable Long id) {
        return addressService.getAddressById(id);
    }

    @PutMapping("/{id}")
    public Address updatAddress(@PathVariable Long id, @RequestBody Address addressDetails) {
        Optional<Address> address = addressService.getAddressById(id);
        if (address.get() != null) {
            Address addressOut = address.get();
            addressOut.setLine1(addressDetails.getLine1());
            addressOut.setLine2(addressDetails.getLine2());
            addressOut.setSuburb(addressDetails.getSuburb());
            addressOut.setCity(addressDetails.getCity());
            addressOut.setProvince(addressDetails.getProvince());
            addressOut.setCode(addressDetails.getCode());
            addressService.saveAddress(addressOut);
            return addressOut;

        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteById(id);
    }

}
