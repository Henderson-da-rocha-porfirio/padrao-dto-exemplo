package com.tuyofood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tuyofood.domain.exception.EntidadeEmUsoException;
import com.tuyofood.domain.exception.EstadoNaoEncontradoException;
import com.tuyofood.domain.model.Estado;
import com.tuyofood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

	private static final String MSG_ESTADO_EM_USO 
		= "Estado de código %d não pode ser removido, pois está em uso";
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Transactional
	public Estado salvar(Estado estado) {
		return estadoRepository.save(estado);
	}
	
	@Transactional
	public void excluir(Long estadoId) {
		try {
			estadoRepository.deleteById(estadoId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new EstadoNaoEncontradoException(estadoId);
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format(MSG_ESTADO_EM_USO, estadoId));
		}
	}

	public Estado buscarOuFalhar(Long estadoId) {
		return estadoRepository.findById(estadoId)
			.orElseThrow(() -> new EstadoNaoEncontradoException(estadoId));
	}
	
}
