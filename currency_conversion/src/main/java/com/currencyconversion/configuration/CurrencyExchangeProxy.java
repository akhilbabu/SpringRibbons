package com.currencyconversion.configuration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.currencyconversion.bean.CurrencyConversionBean;

@FeignClient(name="forex-service",url="localhost:8000")
public interface CurrencyExchangeProxy
{
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean conversionBean(@PathVariable("from") String from,@PathVariable("to") String to);
			
}
