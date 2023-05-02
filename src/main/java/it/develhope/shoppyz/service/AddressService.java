package it.develhope.shoppyz.service;


import it.develhope.shoppyz.entity.Address;
import it.develhope.shoppyz.repository.AddressRepository;
import java.util.List;
import java.util.Optional;

public interface AddressService {

    public Optional<Address> getAddress(Integer id);
    public void deleteAddress(Address address);
    public void saveAddress(Address address);
    void updateAddress(Address address);
    public List<Address> getAddressList();

}
