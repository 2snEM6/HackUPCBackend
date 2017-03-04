package Handler;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;
import sun.rmi.rmic.Constants;

import java.io.ByteArrayInputStream;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by macbook on 4/3/17.
 */
public class FirebaseSetupHandler {

    public static void init() {
        try {
            InputStream stream = new ByteArrayInputStream(Constants.Spark.responseType.FIREBASE_CREDENTIALS.getBytes(StandardCharsets.UTF_8));


            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
                    .setDatabaseUrl("https://alife-93165.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (FileNotFoundException e) {

        }
    }
}
