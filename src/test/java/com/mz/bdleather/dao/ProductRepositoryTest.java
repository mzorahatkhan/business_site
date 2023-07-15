package com.mz.bdleather.dao;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.mz.bdleather.BdLeatherApplication;
import com.mz.bdleather.entities.Product;

@ContextConfiguration(classes=BdLeatherApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@SqlGroup({@Sql(executionPhase=Sql.ExecutionPhase.BEFORE_TEST_METHOD,scripts= {"classpath:schema.sql","classpath:data.sql"}),
    @Sql(executionPhase=Sql.ExecutionPhase.AFTER_TEST_METHOD,scripts="classpath:drop.sql")})
public class ProductRepositoryTest {
@Autowired
ProductRepository prodRepo;
@Test
public void ifProductIsSavedInDatabase()
{
	Product testProduct=new Product("t-Wallet",29.99,"test-description","black");
	prodRepo.save(testProduct);
	assertEquals(11,prodRepo.findAll().size());

  }
}
