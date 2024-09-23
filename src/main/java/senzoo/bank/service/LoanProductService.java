package senzoo.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senzoo.bank.domain.LoanProduct;
import senzoo.bank.repository.LoanProductRepository;

import java.util.List;

@Service
public class LoanProductService {

    private final LoanProductRepository loanProductRepository;

    @Autowired
    public LoanProductService(LoanProductRepository loanProductRepository) {
        this.loanProductRepository = loanProductRepository;
    }

    public List<LoanProduct> getLoanProductList() {
        return loanProductRepository.findAll();
    }
}
