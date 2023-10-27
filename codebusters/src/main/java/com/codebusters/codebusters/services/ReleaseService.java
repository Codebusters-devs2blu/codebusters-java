package com.codebusters.codebusters.services;

import com.codebusters.codebusters.models.dtos.ReleaseDTO;
import com.codebusters.codebusters.models.entities.Release;
import com.codebusters.codebusters.repositories.ReleaseRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReleaseService {

	@Autowired
	private ReleaseRepository releaseRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<ReleaseDTO> listAll() {
		return releaseRepository.findAll().stream().map(release -> modelMapper.map(release, ReleaseDTO.class)).toList();
	}

	public ReleaseDTO findById(Long id) {
		Optional<Release> optional = releaseRepository.findById(id);
		ReleaseDTO releaseDTO = null;

		if (optional.isPresent()) {
			releaseDTO = modelMapper.map(optional.get(), ReleaseDTO.class);
		}
		return releaseDTO;
	}

	public ReleaseDTO create(ReleaseDTO releaseDTO) {
		Release release = modelMapper.map(releaseDTO, Release.class);
		Release createdRelease = releaseRepository.save(release);
		System.out.println(createdRelease);
		ReleaseDTO createdReleaseDTO = modelMapper.map(createdRelease, ReleaseDTO.class);
		return createdReleaseDTO;
	}

	public ReleaseDTO update(ReleaseDTO releaseDTO) {
		Release release = modelMapper.map(releaseDTO, Release.class);
		if (releaseRepository.existsById(release.getId())) {
			Release updatedRelease = releaseRepository.save(release);
			ReleaseDTO updatedReleaseDTO = modelMapper.map(updatedRelease, ReleaseDTO.class);
			return updatedReleaseDTO;
		} else {
			return null;
		}
	}

	public void deleteById(Long id) throws Exception {

		try {
			releaseRepository.deleteById(id);
		} catch (Exception e) {
			throw new Exception("Não foi possivel deletar a Release com esse id");
		}
	}

}
