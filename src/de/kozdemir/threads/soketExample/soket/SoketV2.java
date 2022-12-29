package de.kozdemir.threads.soketExample.soket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.MessageFormat;
import java.util.Calendar;

import de.kozdemir.threads.soketExample.queue.DataQueue;

public class SoketV2 implements Runnable {

	private static final int PORT_NUMBER = 9999;
	private static final String HOST_NAME = "localhost";
	
	@Override
	public void run() {
		Socket client = null;
		BufferedReader reader = null;
		try {
			client = new Socket(HOST_NAME, PORT_NUMBER);
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String data = null;
			while((data = reader.readLine()) != null) {
				System.out.println(MessageFormat.format("Gelen Veri: {0}, Gelme Saniyesi: {1}", data,Calendar.getInstance().get(Calendar.SECOND)));
				DataQueue.add(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeReader(reader);
			closeSocket(client);
		}
	}

	private void closeReader(BufferedReader reader) {
		try {
			if(reader != null) {
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void closeSocket(Socket soket) {
		try {
			if(soket != null) {
				soket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
