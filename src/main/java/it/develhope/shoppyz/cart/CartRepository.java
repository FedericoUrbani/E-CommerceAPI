package it.develhope.shoppyz.cart;

import it.develhope.shoppyz.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    Optional<Cart> findById(Integer id);

    @Override
    void deleteById(Integer integer);

    List<Cart> findAll();

}
