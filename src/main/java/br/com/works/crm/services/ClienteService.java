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
	
	public void delete(int id) {
		clienteRepository.deleteById(id);
		
	}
	
	public Cliente update(int id, Cliente cliente) {
 		Cliente clienteAtual = clienteRepository.findById(id).get();
		clienteAtual.setNome(cliente.getNome());
//		BeanUtils.copyProperties(cliente, clienteAtual, "id"); 
		return clienteRepository.save(clienteAtual);
		 
	}
}
