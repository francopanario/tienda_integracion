package server;

import interfazRemota.InterfazRemota;
import objetoRemoto.ObjetoRemoto;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

import delegado.BusinessDelegate;

public class Server {

	public static void main(String[] args) throws RemoteException {
		new Server();
		//BusinessDelegate.getInstancia().cargarTodasUbicacionesYArticulos();

	}
	public Server() {
		publicar();
	}
	
	
	private void publicar() {
	
		
		try {
    		LocateRegistry.createRegistry(1099);
            InterfazRemota ir = new ObjetoRemoto();
            Naming.rebind ("//localhost/tienda", ir);
            System.out.println("Servidor Iniciado en //localhost/tienda");
		} catch (RemoteException e) {
			e.printStackTrace();
			//JOptionPane.showMessageDialog(null, "Error de iniciaización del objeto remoto");
		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(null, "Error de publicación del objeto");
		}
    }
	
	
}
