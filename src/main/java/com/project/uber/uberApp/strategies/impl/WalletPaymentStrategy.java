package com.project.uber.uberApp.strategies.impl;

import com.project.uber.uberApp.entities.Driver;
import com.project.uber.uberApp.entities.Payment;
import com.project.uber.uberApp.entities.Rider;
import com.project.uber.uberApp.entities.enums.PaymentStatus;
import com.project.uber.uberApp.entities.enums.TransactionMethod;
import com.project.uber.uberApp.repositories.PaymentRepository;
import com.project.uber.uberApp.services.PaymentService;
import com.project.uber.uberApp.services.WalletService;
import com.project.uber.uberApp.strategies.PaymentStrategy;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


//Rider has 232, Driver had 500
//Ride cost is 100, commission = 30
//Rider -> 232-100 = 132
//Driver -> 500+(100-30)=570


@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
        Rider rider = payment.getRide().getRider();

        walletService.deductMoneyFromWallet(rider.getUser(), payment.getAmount(), null, payment.getRide(), TransactionMethod.RIDE);
        double driverCut = payment.getAmount() * (1 - PLATFORM_COMMISSION);
        walletService.addMoneyToWallet(driver.getUser(), driverCut, null, payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}
