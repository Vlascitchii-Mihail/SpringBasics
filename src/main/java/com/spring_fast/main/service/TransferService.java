package com.spring_fast.main.service;

import com.spring_fast.main.model.Account;
import com.spring_fast.main.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional("msqlTransactionManager")
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
        Account sender = accountRepository.findAccountById(idSender);
        Account receiver = accountRepository.findAccountById(idReceiver);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAccount(idSender, senderNewAmount);
        accountRepository.changeAccount(idReceiver, receiverNewAmount);

        throw new RuntimeException("Oh no! Something went wrong");
    }

    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }
}
