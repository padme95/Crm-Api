package br.com.works.crm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.works.crm.model.Cliente;
import br.com.works.crm.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> findAll(Cliente cliente) {
		return clienteRepository.findAll();
	}
	
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}
