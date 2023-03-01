package it.develhope.shoppyz.user;

import it.develhope.shoppyz.account.Agency;
import it.develhope.shoppyz.address.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AgencyTest {
    Address address;
    Agency agency;
    @BeforeEach
    void setUpAgency(){
         address= new Address("via leornardo da vinci","palermo","italy","90145");
         agency= new Agency(address,"x1","x1@gmail.com","1111111");

    }


    @Test
    void runAgencyTest(){
        System.out.println(agency.toString());
    }

}
