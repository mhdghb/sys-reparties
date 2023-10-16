package ClientPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import OperationPackage.Operation;

public class Client {
	public static void main(String[] args) throws ClassNotFoundException {
		try {	InetAddress ia =InetAddress.getByName("10.27.14.152");
			InetSocketAddress isa =new InetSocketAddress(ia,1234);//pour ladresse de serveur
			Socket s =new Socket("localhost",1234);
			s.connect(isa);
		System.out.println("donner un nombre");
		OutputStream os=s.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(os);
		Operation ope = new Operation(40,20,'*');
		oos.writeObject(ope);

		InputStream is=s.getInputStream();
		ObjectInputStream iis = new ObjectInputStream(is);
		ope = (Operation) iis.readObject();
		System.out.println(ope.getRes());
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("la premiere valeur");
		int nb1=scanner.nextInt();
		System.out.println("l'operateur est");
		String op=scanner.nextLine();
		System.out.println("la deuxieme valeur");
		int nb2=scanner.nextInt();
		PrintWriter pw = new PrintWriter(os, true);//true = bl ligne bl ligne
		pw.println( nb1);
		pw.println( nb2);
		pw.println( op);
		InputStreamReader isr= new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr); 
		System.out.println(nb1+" "+op+""+nb2+"="+br.readLine());
		s.close();
	}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
}
