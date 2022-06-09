package br.com.works.crm.services;

import java.util.List;
import java.util.Optional;

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
	
	public Cliente getOne(int id) {
		return clienteRepository.findById(id).orElse(new Cliente());
	}
	
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void delete(int id) {
		clienteRepository.deleteById(id);
		
	}
	
	public Cliente update(int id, Cliente novoCliente) {

		Optional<Cliente> optional = clienteRepository.findById(id);
		if(optional.isPresent()) {
			Cliente cliente = optional.get();
			cliente.setNome(novoCliente.getNome());
			return clienteRepository.save(cliente);
			}
			return new Cliente();
//	Outra Opção:	BeanUtils.copyProperties(cliente, clienteAtual, "id"); 
// Esse código acima, faz a cópia dos valores de um para outro. de cliente para cliente atual, exceto o "id".
		 
	}
}
