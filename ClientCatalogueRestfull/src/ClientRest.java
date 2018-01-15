import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import metier.entities.*;

public class ClientRest {
	public static void main(String[] args) throws Exception{
		
		Client client= Client.create(new DefaultClientConfig());
		URI uri=UriBuilder.fromUri("http://localhost:8080/TPwsjrs/").build();
		
		//String  catSTR="{\"idCategorie\":5,\"nomCategorie\":\"AAA\",\"photo\":\"AAA.jpg\"}";	
		Categorie c2=new Categorie(4L,"AAAA", "AAAA.jpg");
		ObjectMapper mapper=new ObjectMapper();
		ClientResponse rep2=client.resource(uri).path("catalogue").path("categories").type(MediaType.APPLICATION_JSON).post(ClientResponse.class,mapper.writeValueAsString(c2));//catSTR
		System.out.println(rep2.getEntity(String.class));
		
		//Consulter toutes les categuorie
		ClientResponse response=client.resource(uri).path("catalogue").path("categories").get(ClientResponse.class);
		String corpsRepHttp=response.getEntity(String.class);
		System.out.println(corpsRepHttp);
		
		//ObjectMapper mapper=new ObjectMapper();
		Categorie[] cats=mapper.readValue(corpsRepHttp, Categorie[].class);
		for(Categorie c: cats){
			System.out.println(c.getNomCategorie());
		}
		
	}

}
