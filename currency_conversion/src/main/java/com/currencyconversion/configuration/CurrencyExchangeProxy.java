package com.currencyconversion.configuration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.currencyconversion.bean.CurrencyConversionBean;

@FeignClient(name="forex-service")
@RibbonClient(name="forex-service")
public interface CurrencyExchangeProxy
{
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean conversionBean(@PathVariable("from") String from,@PathVariable("to") String to);
			
}
