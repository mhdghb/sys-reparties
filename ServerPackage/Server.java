package ServerPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import OperationPackage.Operation;

public class Server {
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss =new ServerSocket(1234);	
		System.out.println("je suis un serveur en attente la connexion d'un client");
		Socket s =ss.accept();
		System.out.println("un client est connecté");
		InputStream is=s.getInputStream();
		ObjectInputStream oi = new ObjectInputStream(is);
		Operation op=(Operation) oi.readObject();
		int nb1=op.getOp1();
		int nb2=op.getOp2();
		int ops=op.getOperation();
		int res=0;
		switch(ops){
        case '+' : res = nb1 + nb2;break;
        case '-' : res = nb1 - nb2;break;
        case '*' : res = nb1 * nb2;break;
        case '/' : res = nb1 / nb2;break;
    }
		op.setRes(res);
		
		
		
		OutputStream os=s.getOutputStream();
		 ObjectOutputStream oos = new ObjectOutputStream(os);

         oos.writeObject(op);

		
		
		int op1,op2;
		PrintWriter pw = new PrintWriter(os, true);
		InputStreamReader isr= new InputStreamReader(is);// bch yredha bl character bl character 
		BufferedReader br = new BufferedReader(isr); //bch ylemhom 5 0 0 0 0 -> 50000
		op1=Integer.parseInt(br.readLine());
		op2=Integer.parseInt(br.readLine());
		switch(br.readLine())
		{case"+":pw.println(op1+op2);
		case"-":pw.println(op1-op2);
		case"*":pw.println(op1*op2);
		case"/":pw.println(op1/op2);
		}
		s.close();
		ss.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}}
