package senzoo.bank.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import senzoo.bank.domain.CalculatorForm;
import senzoo.bank.domain.CalculatorResult;
import senzoo.bank.domain.LoanProduct;
import senzoo.bank.service.LoanCalculator;
import senzoo.bank.service.LoanProductService;

import java.util.List;

@Controller
@Slf4j
public class LoanController {

    LoanCalculator calculator = new LoanCalculator();
    LoanProductService loanProductService;

    @Autowired
    public LoanController(LoanProductService loanProductService) {
        this.loanProductService = loanProductService;
    }

    @GetMapping("/loanCalculator")
    public String calculatorForm(Model model, CalculatorForm calculatorForm) {
        model.addAttribute("CalculatorForm", calculatorForm);
        return "loanCalculation";
    }

    @PostMapping("/loanCalculator")
    public String calculatorForm(@ModelAttribute("calculationForm") CalculatorForm calculatorForm, Model model) {
        log.info("price={}", calculatorForm.getPrice());
        log.info("period={}", calculatorForm.getPeriod());
        log.info("rate={}", calculatorForm.getRate());
        log.info("method={}", calculatorForm.getMethod());

        CalculatorResult result = calculator.calculateResult(calculatorForm);    // 이자를 계산한 결과를 컨트롤러로 담아옴
        log.info("principal={}", result.getPrincipal());
        log.info("interest={}", result.getInterest());
        log.info("monthly payment={}", result.getMonthlyPayment());

        model.addAttribute("calculatorForm", calculatorForm);       // 템플릿 뷰 페이지를 오류없이 렌더링 해주어야 하기 때문에 calculatorForm 객체도 모델에 추가해주어야 함
        model.addAttribute("result", result);

        return "loanCalculation";
    }

    @GetMapping("/loanProductList")
    public String loanProductList(Model model) {

        // 기금대출상품 목록 조회
        List<LoanProduct> loanProductList = loanProductService.getLoanProductList();
        model.addAttribute("loanProductList", loanProductList);

        return "loanProductList";
    }
}
