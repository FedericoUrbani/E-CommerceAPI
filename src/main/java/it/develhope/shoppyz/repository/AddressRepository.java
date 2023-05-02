package it.develhope.shoppyz.repository;


import it.develhope.shoppyz.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

    Optional<Address> findById(Integer id);

}