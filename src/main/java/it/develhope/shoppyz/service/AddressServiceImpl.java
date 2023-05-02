package it.develhope.shoppyz.service;

import it.develhope.shoppyz.entity.Address;
import it.develhope.shoppyz.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Override
    public Optional<Address> getAddress(Integer id) {
        return addressRepository.findById(id);
    }

    @Override
    public void deleteAddress(Address address) {
        addressRepository.delete(address);
    }

    @Override
    public void saveAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void updateAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public List<Address> getAddressList() {
       return addressRepository.findAll();
    }
}
