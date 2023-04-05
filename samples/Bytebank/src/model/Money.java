package model;

import java.math.BigDecimal;

import model.enums.Currency;

public class Money {
  private BigDecimal value;
  private Currency currency;

  public Money(BigDecimal value, Currency currency) {
    this.value = value;
    this.currency = currency;
  }

  public Currency getCurrency() {
    return currency;
  }

  public BigDecimal getValueIn(Currency currency) {
    Money copy = new Money(this.value, this.currency);
    copy.convert(currency);
    return copy.value;
  }
  public Money changeCurrencyTo(Currency currency) {
    this.convert(currency);
    return this;
  }

  public BigDecimal sum(Money money) {
    money.convert(this.currency);
    return this.value = this.value.add(money.value);
  }

  public BigDecimal subtract(Money money) {
    money.convert(this.currency);
    return this.value = this.value.subtract(money.value);
  }

  private void convert(Currency target) {
    BigDecimal usdToEur = new BigDecimal("0.85");
    BigDecimal eurToUsd = new BigDecimal("1.18");

    switch (this.currency) {
      case USD -> {
        switch (target) {
          case EUR -> this.value = this.value.multiply(usdToEur);
        }
      }
      case EUR -> {
        switch (target) {
          case USD -> this.value = this.value.multiply(eurToUsd);
        }
      }
    };

    this.currency = target;
  }
}
