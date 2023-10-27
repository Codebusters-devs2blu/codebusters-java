package com.codebusters.codebusters.services;

import com.codebusters.codebusters.models.dtos.ReleaseDTO;
import com.codebusters.codebusters.models.entities.Release;
import com.codebusters.codebusters.repositories.ReleaseRepository;
import jakarta.validation.Valid;
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
		return releaseRepository.findAll().stream()
				.map(release -> modelMapper.map(release, ReleaseDTO.class)).toList();
	}

	public ReleaseDTO findById(Long id) {
		Optional<Release> optional = releaseRepository.findById(id);
		ReleaseDTO releaseDTO = null;

		if (optional.isPresent()) {
			releaseDTO = modelMapper.map(optional.get(), ReleaseDTO.class);
		}
		return releaseDTO;
	}

	public ResponseEntity<ReleaseDTO> create(@Valid ReleaseDTO releaseDTO) {
		Release release = modelMapper.map(releaseDTO, Release.class);
		Release createdRelease = releaseRepository.save(release);
		ReleaseDTO createdReleaseDTO = modelMapper.map(createdRelease, ReleaseDTO.class);
		return new ResponseEntity<>(createdReleaseDTO, HttpStatus.CREATED);
	}

	public ResponseEntity<ReleaseDTO> update(@Valid ReleaseDTO releaseDTO) {
		Release release = modelMapper.map(releaseDTO, Release.class);
		if (releaseRepository.existsById(release.getId())) {
			Release updatedRelease = releaseRepository.save(release);
			ReleaseDTO updatedReleaseDTO = modelMapper.map(updatedRelease, ReleaseDTO.class);
			return new ResponseEntity<>(updatedReleaseDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public void deleteById(Long id) {
		releaseRepository.deleteById(id);
	}



}
