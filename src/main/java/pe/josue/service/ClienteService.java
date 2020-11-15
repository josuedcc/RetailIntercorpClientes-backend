package pe.josue.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import pe.josue.dto.ClienteDto;
import pe.josue.dto.ClienteModel;
import pe.josue.dto.KpiClienteDto;
import pe.josue.dto.ResponseCreaCliente;

public interface ClienteService {
	public ResponseCreaCliente creaCliente(ClienteModel cliente) throws InterruptedException, ExecutionException;
	
	public KpiClienteDto kpideclientes() throws InterruptedException, ExecutionException;
	
	public List<ClienteDto> listClientes() throws InterruptedException, ExecutionException;
	
	
}
