package it.develhope.shoppyz.relationProdCart;

import it.develhope.shoppyz.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;


@RepositoryRestResource
public interface CartProductRepository extends JpaRepository<CartProduct ,Long> {

    /** returns all the products id from the cart id **/
    @Query("SELECT  p.product FROM CartProduct p WHERE p.cart= :cartId")
    List<CartProduct> getListOfProductInCart(@Param("cartId") Long cartId);

}

