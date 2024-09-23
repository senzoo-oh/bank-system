package senzoo.bank.service;

import org.springframework.stereotype.Service;
import senzoo.bank.domain.CalculatorForm;
import senzoo.bank.domain.CalculatorResult;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;

@Service
public class LoanCalculator {

    public CalculatorResult calculateResult(CalculatorForm calculatorForm) {
        int price = calculatorForm.getPrice();
        int period = calculatorForm.getPeriod();
        float rate = calculatorForm.getRate();
        String method = calculatorForm.getMethod();

        CalculatorResult result = new CalculatorResult();

        int principal;          // 상환원금
        int interest;           // 이자금액
        int monthlyPayment;     // 월 납부금액

        if (method.equals("만기일시상환")) {
            principal = 0;
            interest = (int) ceil(price * ((rate * 0.01) / 12));
            monthlyPayment = interest;
        }
        else if (method.equals("원금균등분할상환")) {
            principal = (int) (price / (period * 12));
            interest = (int) ceil(price * ((rate * 0.01) / 12));;
            monthlyPayment = principal + interest;
        }
        else {
            principal = 0;
            interest = 0;
            monthlyPayment = 0;
        }

        result.setPrincipal(principal);
        result.setInterest(interest);
        result.setMonthlyPayment(monthlyPayment);

        return result;
    }
}
