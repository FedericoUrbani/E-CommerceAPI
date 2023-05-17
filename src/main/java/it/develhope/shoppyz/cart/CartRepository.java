package it.develhope.shoppyz.cart;

import it.develhope.shoppyz.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findById(Long id);

    @Override
    void deleteById(Long integer);

    List<Cart> findAll();

}
