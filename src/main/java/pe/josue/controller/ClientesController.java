package pe.josue.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.josue.dto.ClienteDto;
import pe.josue.dto.ClienteModel;
import pe.josue.dto.KpiClienteDto;
import pe.josue.dto.ResponseCreaCliente;
import pe.josue.service.ClienteService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ClientesController {
	
	@Autowired
	ClienteService clienteService;
	
	@PostMapping(value = "creacliente", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<ResponseCreaCliente> creaCliente(@Valid @RequestBody ClienteModel cliente) throws InterruptedException, ExecutionException {
		ResponseCreaCliente responseCreaCliente = clienteService.creaCliente(cliente);
		return ResponseEntity.status(HttpStatus.OK).body(responseCreaCliente);
	}
	
	@GetMapping(value = "kpideclientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<KpiClienteDto> kpideClientes() throws InterruptedException, ExecutionException {
		KpiClienteDto kpiClienteDto= clienteService.kpideclientes();
		return ResponseEntity.status(HttpStatus.OK).body(kpiClienteDto);
	}
	
	@GetMapping(value = "listclientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<List<ClienteDto>> listClientes() throws InterruptedException, ExecutionException {
		List<ClienteDto> list = clienteService.listClientes();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
}
