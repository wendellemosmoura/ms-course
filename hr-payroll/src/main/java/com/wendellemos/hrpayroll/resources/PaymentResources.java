package com.wendellemos.hrpayroll.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wendellemos.hrpayroll.entities.Payment;
import com.wendellemos.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResources {

    @Autowired
    private PaymentService paymentService;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable int days) {
        Payment payment = paymentService.getPayment(workerId, days);
        return ResponseEntity.ok(payment);
    }
    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, int days) {
        Payment payment = new Payment("Error", 0.0, days);
        return ResponseEntity.ok(payment);
    }
}
