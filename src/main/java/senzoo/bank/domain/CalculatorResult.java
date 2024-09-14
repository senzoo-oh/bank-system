package senzoo.bank.domain;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CalculatorResult {
    @Id
    int id;

    int principal;          // 상환원금
    int interest;           // 이자금액
    int monthlyPayment;     // 월 납부금액
}
