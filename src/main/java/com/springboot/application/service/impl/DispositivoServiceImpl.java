package com.springboot.application.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.application.model.Dispositivo;
import com.springboot.application.repository.DispositivoRepository;
import com.springboot.application.service.DispositivoService;


public  class DispositivoServiceImpl implements DispositivoService{
	
	@Autowired
	private DispositivoRepository dispositivoRepository;
	
	@Autowired
	private DispositivoService dispositivoService;
	
	public DispositivoServiceImpl(DispositivoRepository dispositivoRepository) {
		super();
		this.dispositivoRepository = dispositivoRepository;
	}

	@Override
	public List<Dispositivo> buscarTodosDispositivos() {
		return dispositivoRepository.findAll();
	}

	@Override
	public Dispositivo salvarDispositivo(Dispositivo dispositivo)  {
	
		return dispositivoRepository.save(dispositivo);
	}

	@Override
	public Dispositivo pegarDispositivoPeloId(Long id) {
		return dispositivoRepository.findById(id).get();
	}

	@Override
	public Dispositivo atualizarDispositivo(Dispositivo dispositivo) {
		return dispositivoRepository.save(dispositivo);
	}

	@Override
	public void apagarDispositivoPeloId(Long id) {
		dispositivoRepository.deleteById(id);
		
	}

	
	

}
