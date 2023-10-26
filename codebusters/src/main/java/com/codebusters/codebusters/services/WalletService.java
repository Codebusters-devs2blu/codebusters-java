package com.codebusters.codebusters.services;

import com.codebusters.codebusters.models.dtos.WalletDTO;
import com.codebusters.codebusters.models.entities.Wallet;
import com.codebusters.codebusters.repositories.WalletRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

	public WalletDTO findById(Long id) {
		Optional<Wallet> walletOptional = walletRepository.findById(id);
		return walletOptional.map(wallet -> modelMapper.map(wallet, WalletDTO.class)).orElse(null);
	}

	public WalletDTO create(@Valid WalletDTO walletDTO) {
		Wallet wallet = modelMapper.map(walletDTO, Wallet.class);
		Wallet createdWallet = walletRepository.save(wallet);
		return modelMapper.map(createdWallet, WalletDTO.class);
	}

	public WalletDTO update(@Valid WalletDTO walletDTO) {
		Wallet wallet = modelMapper.map(walletDTO, Wallet.class);
		if (walletRepository.existsById(wallet.getId())) {
			Wallet updatedWallet = walletRepository.save(wallet);
			return modelMapper.map(updatedWallet, WalletDTO.class);
		} else {
			return null; // Ou lançar uma exceção adequada, por exemplo, WalletNotFoundException
		}
	}

	public void deleteById(Long id) {
		walletRepository.deleteById(id);
	}
}
