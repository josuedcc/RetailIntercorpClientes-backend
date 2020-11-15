package pe.josue.service.implement;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

import pe.josue.dto.ClienteDto;
import pe.josue.dto.ClienteModel;
import pe.josue.dto.KpiClienteDto;
import pe.josue.dto.ResponseCreaCliente;
import pe.josue.service.ClienteService;
import pe.josue.util.Util;

@Service
public class ClientServiceImplement implements ClienteService {

	@Override
	public ResponseCreaCliente creaCliente(ClienteModel cliente) {
		// TODO Auto-generated method stub
		Firestore dbFireStore = FirestoreClient.getFirestore();
		ApiFuture<DocumentReference> collecionApiFuture = dbFireStore.collection("clientes").add(cliente);
		try {
			return new ResponseCreaCliente("0", collecionApiFuture.get().getId());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			return new ResponseCreaCliente("1", e.getMessage());
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			return new ResponseCreaCliente("2", e.getMessage());
		}
	}

	@Override
	public List<ClienteDto> listClientes() throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		Firestore dbFireStore = FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> collecionApiFuture = dbFireStore.collection("clientes").get();
		List<QueryDocumentSnapshot> documentSnapshots = collecionApiFuture.get().getDocuments();
		List<ClienteDto> lisClienteModels = new ArrayList<ClienteDto>();
		for (DocumentSnapshot document : documentSnapshots) {
				ClienteModel clienteModel = document.toObject(ClienteModel.class);

				ClienteDto rspClient = new ClienteDto(
						clienteModel.getNombre(), 
						clienteModel.getApellido(), 
						clienteModel.getEdad(), 
						clienteModel.getFecNacomiento(), 
						Util.generarFechaMuerte(clienteModel.getFecNacomiento()),
						document.getId());
				lisClienteModels.add(rspClient);
		}
		return lisClienteModels;
	}

	private static DecimalFormat df2 = new DecimalFormat("#.##");
	@Override
	public KpiClienteDto kpideclientes() throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		Firestore dbFireStore = FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> collecionApiFuture = dbFireStore.collection("clientes").get();
		List<QueryDocumentSnapshot> documentSnapshots = collecionApiFuture.get().getDocuments();
		List<Integer> edades = new ArrayList<Integer>();
		for (DocumentSnapshot document : documentSnapshots) {
				ClienteModel clienteModel = document.toObject(ClienteModel.class);
				edades.add(clienteModel.getEdad());
		}
		
		KpiClienteDto kpiClienteDto = new KpiClienteDto(
				Util.obtenerPromedio(edades), Util.obtenerDesviacion(edades));
		
		return kpiClienteDto;
	}

}
