package com.codebusters.codebusters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codebusters.codebusters.services.WalletService;

@RestController
@RequestMapping(value = "/api/wallet")
public class WalletController {

	@Autowired
	private WalletService walletService;
}
