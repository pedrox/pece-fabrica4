package br.usp.poli.pece.poc;

import java.util.List;
import javax.xml.ws.Endpoint;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class PocMain {
	
	private static Endpoint alunos;


	public static void main(String[] args) {
		runServer();
		
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(PocIntegracaoInterface.class);
		factory.setAddress("http://localhost:9000/PocIntegracao");
		PocIntegracaoInterface client = (PocIntegracaoInterface) factory.create();

		List<String> lista = client.listaAlunos();
		System.out.println(lista);
		
		stopServer();
	}
	
	public static void runServer() {
		System.out.print("Starting Server... ");
		PocIntegracao teste = new PocIntegracao();
		String address = "http://localhost:9000/PocIntegracao";
		alunos = Endpoint.publish(address, teste);
		System.out.println("Done!");
	}
	
	public static void stopServer() {
		alunos.stop();
		alunos = null;
	}

}
