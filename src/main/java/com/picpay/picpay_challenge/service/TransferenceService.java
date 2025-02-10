package com.picpay.picpay_challenge.service;

import com.picpay.picpay_challenge.domain.CommonUser;
import com.picpay.picpay_challenge.domain.Retailer;
import com.picpay.picpay_challenge.domain.Transference;
import com.picpay.picpay_challenge.repository.CommonUserRepository;
import com.picpay.picpay_challenge.repository.RetailerRepository;
import com.picpay.picpay_challenge.repository.TransferenceRepository;
import com.picpay.picpay_challenge.request.TransferencePostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static com.picpay.picpay_challenge.util.Constants.*;

@Service
@RequiredArgsConstructor
public class TransferenceService {
    private final CommonUserRepository commonUserRepository;
    private final RetailerRepository retailerRepository;
    private final TransferenceRepository transferenceRepository;


    private final Map<Predicate<String>, Consumer<TransferencePostRequest>> transferHandlers = Map.of(
            s -> s.matches(CPF_VALIDATION), this::transferenceToCommonUser,
            s -> s.matches(CNPJ_VALIDATION), this::transferenceToRetailer
    );


    public void transference(TransferencePostRequest request) {

        commonUserRepository.findByCpf(request.getPayer())
                .map(CommonUser::getAccountBalance)
                .filter(balance -> balance > request.getValue())
                .orElseThrow(() -> new IllegalArgumentException(INSUFFICIENT_BALANCE));

        transferHandlers.entrySet().stream()
                .filter(entry -> entry.getKey().test(request.getPayee()))
                .map(Map.Entry::getValue)
                .findFirst()
                .ifPresent(handler -> handler.accept(request));
    }


    public void transferenceToCommonUser(TransferencePostRequest request) {

        var payer = getPayerNotFound(request);
        var commonUserPayee = getPayeeNotFound(request);

        payer.setAccountBalance(payer.getAccountBalance() - request.getValue());
        commonUserPayee.setAccountBalance(commonUserPayee.getAccountBalance() + request.getValue());

        commonUserRepository.save(payer);
        commonUserRepository.save(commonUserPayee);

        var transference = new Transference();

        transference.setPayer(payer);
        transference.setCommonUserPayee(commonUserPayee);
        transference.setValue(request.getValue());

        transferenceRepository.save(transference);
    }



    public void transferenceToRetailer(TransferencePostRequest request) {

        var payer = getPayerNotFound(request);
        var retailerPayee = getRetailerPayeeNotFound(request);

        payer.setAccountBalance(payer.getAccountBalance() - request.getValue());
        retailerPayee.setAccountBalance(retailerPayee.getAccountBalance() + request.getValue());

        commonUserRepository.save(payer);
        retailerRepository.save(retailerPayee);

        var transference = new Transference();

        transference.setPayer(payer);
        transference.setRetailerPayee(retailerPayee);
        transference.setValue(request.getValue());

        transferenceRepository.save(transference);
    }


    private CommonUser getPayerNotFound(TransferencePostRequest request) {
        return commonUserRepository.findByCpf(request.getPayer())
                .orElseThrow(() -> new RuntimeException(PAYER_NOT_FOUND));
    }

    private CommonUser getPayeeNotFound(TransferencePostRequest request) {
        return commonUserRepository.findByCpf(request.getPayee())
                .orElseThrow(() -> new RuntimeException(PAYEE_NOT_FOUND));
    }

    private Retailer getRetailerPayeeNotFound(TransferencePostRequest request) {
        return retailerRepository.findByCnpj(request.getPayee())
                .orElseThrow(() -> new RuntimeException(PAYEE_NOT_FOUND));
    }

    //TODO Uso de Exceções Personalizadas
    //Em vez de RuntimeException, criar exceções específicas como UserNotFoundException e InsufficientBalanceException.


}

