package com.codebusters.codebusters.services;

import com.codebusters.codebusters.models.dtos.WalletDTO;
import com.codebusters.codebusters.models.entities.Wallet;
import com.codebusters.codebusters.repositories.WalletRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WalletService {

	@Autowired
	private WalletRepository walletRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<WalletDTO> listAll() {
		List<Wallet> wallets = walletRepository.findAll();
		return wallets.stream()
				.map(wallet -> modelMapper.map(wallet, WalletDTO.class))
				.collect(Collectors.toList());
	}

	public ResponseEntity<WalletDTO> findById(Long id) {
		Optional<Wallet> walletOptional = walletRepository.findById(id);
		if (walletOptional.isPresent()) {
			WalletDTO walletDTO = modelMapper.map(walletOptional.get(), WalletDTO.class);
			return new ResponseEntity<>(walletDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<WalletDTO> create(@Valid WalletDTO walletDTO) {
		Wallet wallet = modelMapper.map(walletDTO, Wallet.class);
		Wallet createdWallet = walletRepository.save(wallet);
		WalletDTO createdWalletDTO = modelMapper.map(createdWallet, WalletDTO.class);
		return new ResponseEntity<>(createdWalletDTO, HttpStatus.CREATED);
	}

	public ResponseEntity<WalletDTO> update(@Valid WalletDTO walletDTO) {
		Wallet wallet = modelMapper.map(walletDTO, Wallet.class);
		if (walletRepository.existsById(wallet.getId())) {
			Wallet updatedWallet = walletRepository.save(wallet);
			WalletDTO updatedWalletDTO = modelMapper.map(updatedWallet, WalletDTO.class);
			return new ResponseEntity<>(updatedWalletDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public void deleteById(Long id) {
		walletRepository.deleteById(id);
	}
}
