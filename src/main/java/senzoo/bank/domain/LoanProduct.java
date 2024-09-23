package senzoo.bank.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity(name = "loan_product")
@Getter
public class LoanProduct {

    @Id
    @Column(name = "loan_id")
    private Integer loanId;

    @Column(name = "loan_name")
    private String loanName;        // 대출상품명

    @Column(name = "loan_target")
    private String loanTarget;      // 대출대상

    @Column(name = "interest_rate")
    private String interestRate;    // 대출금리

    @Column(name = "loan_limit")
    private String loanLimit;       // 대출한도

    @Column(name = "loan_term")
    private String loanTerm;        // 대출기간

    @Column(name = "loan_detail_link")
    private String loanLink;
}
