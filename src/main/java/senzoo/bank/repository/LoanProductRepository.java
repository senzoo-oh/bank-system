package senzoo.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senzoo.bank.domain.LoanProduct;

import java.util.List;

@Repository
public interface LoanProductRepository extends JpaRepository<LoanProduct, Integer> {
    List<LoanProduct> findAll();
}
