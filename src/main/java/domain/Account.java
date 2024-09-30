package domain;

import exceptions.BalanceMustBeEqualOrAboveAmountException;

import java.math.BigInteger;
import java.util.Objects;

public class Account {

    private BigInteger balance;
    private String name;

    public Account(BigInteger balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    synchronized public void deposit(BigInteger amount) {
        this.balance = this.balance.add(amount);
    }

    synchronized public void withdraw(BigInteger amount) {
        // account from balance >= amount
        var compareValue = this.balance.compareTo(amount);
        if (compareValue < 0) {
            throw new BalanceMustBeEqualOrAboveAmountException();
        }
        this.balance = this.balance.add(amount.negate());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Account obj) {
        return Objects.equals(this.name, obj.name);
    }
}
