package com.picpay.picpay_challenge.service;

import com.picpay.picpay_challenge.domain.Transference;
import com.picpay.picpay_challenge.repository.CommonUserRepository;
import com.picpay.picpay_challenge.repository.RetailerRepository;
import com.picpay.picpay_challenge.repository.TransferenceRepository;
import com.picpay.picpay_challenge.request.TransferencePostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferenceService {
    private final CommonUserRepository commonUserRepository;
    private final RetailerRepository retailerRepository;
    private final TransferenceRepository transferenceRepository;


    public void transference(TransferencePostRequest request) {

        if (request.getPayee().matches("(\\d{3}[.]?\\d{3}[.]?\\d{3}-\\d{2})|(\\d{11})")) {
            transferenceToCommonUser(request);
        }
        else if (request.getPayee().matches("(\\d{2}[.]?\\d{3}[.]?\\d{3}[/]?\\d{4}[-]?\\d{2})")) {
            transferenceToRetailer(request);
        }

    }


    public void transferenceToCommonUser(TransferencePostRequest request) {

        var payer = commonUserRepository.findByCpf(request.getPayer())
                .orElseThrow(() -> new RuntimeException("Payer not found"));


        var commonUserPayee = commonUserRepository.findByCpf(request.getPayee())
                .orElseThrow(() -> new RuntimeException("Payee not found"));


        //TODO Criar método que verifica se o saldo do 'payer' é positivo

        if (payer.getAccountBalance() < request.getValue()) {
            throw new RuntimeException("Insufficient balance");
        }

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

        var payer = commonUserRepository.findByCpf(request.getPayer())
                .orElseThrow(() -> new RuntimeException("Payer not found"));


        var retailerPayee = retailerRepository.findByCnpj(request.getPayee())
                .orElseThrow(() -> new RuntimeException("Payee not found"));




        if (payer.getAccountBalance() < request.getValue()) {
            throw new RuntimeException("Insufficient balance");
        }

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

    //TODO Criar método que verifica se o saldo do 'payer' é positivo
    //TODO Extração da Validação de CPF e CNPJ
    //Criar um utilitário para validação de CPF e CNPJ em vez de utilizar expressões regulares diretamente no métod o.
    //TODO Uso de Exceções Personalizadas
    //Em vez de RuntimeException, criar exceções específicas como UserNotFoundException e InsufficientBalanceException.


}

