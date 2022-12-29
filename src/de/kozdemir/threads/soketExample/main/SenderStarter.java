package de.kozdemir.threads.soketExample.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class SenderStarter {

	private static List<String> veri;
	private static final int PORT_NUMBER = 9999;
	
	public static void main(String[] args) throws IOException {
		System.out.println("Sunucu uygulama basladi");
		//listemizi dolduruyoruz.
		veriListesiDoldur();
		//sunucu soketimizi olusturduk. 9999 portundan client bekleyecek
		ServerSocket sunucu = new ServerSocket(PORT_NUMBER);
		//baglanacak istemcileri bekliyor. Baglanti saglanana kadar bekler.
		Socket socket = sunucu.accept();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		for(String v : veri) {
			System.out.println(MessageFormat.format("{0} veri gonderiliyor...", v));
			writer.write(v+"\n");
			writer.flush();
		}
		writer.close();
		socket.close();
		sunucu.close();
		System.out.println("Sunucu uygulama sonlandi");
	}
	
	private static void veriListesiDoldur() {
		veri = new ArrayList<String>();
		veri.add("A,B,C");
		veri.add("A,B,C,D");
		veri.add("A,B,C,D,E");
		veri.add("E,F,G");
		veri.add("E,F,G,H");
	}
}
