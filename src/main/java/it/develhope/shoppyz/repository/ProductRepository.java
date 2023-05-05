package it.develhope.shoppyz.repository;

import it.develhope.shoppyz.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository <Product, Integer>{
    @Override
    Optional<Product> findById(Integer id);


}
