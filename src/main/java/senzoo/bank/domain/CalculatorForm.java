package senzoo.bank.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CalculatorForm {
    @Id
    private int id;
    private int price;
    private int period;
    private float rate;
    private String method;
}