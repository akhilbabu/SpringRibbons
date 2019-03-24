package com.currencyconversion.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.currencyconversion.bean.CurrencyConversionBean;
import com.currencyconversion.configuration.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController
{
	@Autowired
	public CurrencyExchangeProxy  proxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertFromAndTo(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity)
	{
		Map<String,String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
//		ResponseEntity<CurrencyConversionBean> entity=new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,uriVariables);
		CurrencyConversionBean bean=proxy.conversionBean(from, to);
//		CurrencyConversionBean bean=entity.getBody();
		bean.setQuantity(quantity);
		bean.setTotalCalculatedAmount(quantity.multiply(bean.getConversionMultiple()));
		return bean;
	}
	
	
	@GetMapping("/test")
	public String currencyConverter()
	{
		return "test";
	}
	

}
