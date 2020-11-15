package pe.josue.config;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirebaseInitialize {

	@PostConstruct
	public void init() {
		try {
			FileInputStream serviceAccount =
					  new FileInputStream("./serviceAccountKey.json");

					FirebaseOptions options = new FirebaseOptions.Builder()
					  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
					  .setDatabaseUrl("https://retailclientes.firebaseio.com")
					  .build();

					FirebaseApp.initializeApp(options);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
