package com.pfyuit.myjavase.java.util;

import java.util.Currency;
import java.util.Locale;
import java.util.Set;

public class CurrencyTest {

	public static void main(String[] args) {
		Set<Currency> currencies = Currency.getAvailableCurrencies();
		for (Currency currency : currencies) {
			printCurrencyInfo(currency);
			System.out.println();
		}

		Currency currency = Currency.getInstance("USD");
		printCurrencyInfo(currency);
		System.out.println();

		currency = Currency.getInstance(Locale.CHINA);
		printCurrencyInfo(currency);
	}

	private static void printCurrencyInfo(Currency currency) {
		System.out.println(currency.getCurrencyCode());
		System.out.println(currency.getDefaultFractionDigits());
		System.out.println(currency.getDisplayName());
		System.out.println(currency.getDisplayName(Locale.CHINA));
		System.out.println(currency.getNumericCode());
		System.out.println(currency.getSymbol());
		System.out.println(currency.getSymbol(Locale.CHINA));
	}

}
