package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SavingAccountTest {
    private final int id = 10;
    private final double amount = 1.0;
    private final Client client = new Client(1, "client");

    @Test
    public void idShouldBeNonNegative() {
        final int negativeId = -1;

        assertThrows(IllegalArgumentException.class,
                () -> new SavingAccount(negativeId, client, amount),
                "Expected non-negative id");
    }

    @Test
    public void amountShouldBeNonNegative() {
        final double negativeAmount = -1.0;

        assertThrows(IllegalArgumentException.class,
                () -> new SavingAccount(id, client, negativeAmount),
                "Expected non-negative amount");
    }

    @Test
    public void clientShouldNotBeNull() {
        final Client nullClient = null;

        assertThrows(IllegalArgumentException.class,
                () -> new SavingAccount(id, nullClient, amount),
                "Expected non-null client");
    }
}
