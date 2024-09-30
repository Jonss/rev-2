package service;

import domain.Account;
import exceptions.AccountMustBeDifferentException;
import exceptions.AmountMustBePositiveException;
import exceptions.BalanceMustBeEqualOrAboveAmountException;

import java.math.BigInteger;

public class BalanceTransferService {

    // A -> B => 10000
    // A -> C => 10000

    // BEGIN TRANSACTION

    // SELECT * FROM ACCOUNT FROM (VERSION)
    // SELECT ACCOUNT TO (VERSION)
    // UPDATE BALANCE FROM.BALANCE -= AMOUNT WHERE VERSION = X
    // UPDATE BALANCE TO.BALANCE += AMOUNT WHERE VERSION = X

    // SELECT from.VERSION FROM (VERSION)
    // SELECT TO.VERSION TO (VERSION)

    // IF from.VERSION != FROM.OLDVERSION || IF TO.VERSION != TO.OLDVERSION

    // IF ERROR -> ROLLBACK

    // UPDATE BALANCE FROM.VERSION += 1
    // UPDATE BALANCE TO.VERSION += 1
    // IF SUCCESS -> COMMIT

    // ANALYZE QUERY

    // A -> B
    // C -> A // ->
    void transfer(Account from, Account to, BigInteger amount) {
        // amount > 0
        if (amount.signum() <= 0) {
            throw new AmountMustBePositiveException();
        }

        // account from and to must be different
        if (from.equals(to)) {
            throw new AccountMustBeDifferentException();
        }

        // get money from origin
        from.withdraw(amount);
        to.deposit(amount);
    }
}
