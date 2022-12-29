package de.kozdemir.threads.soketExample.main;

import de.kozdemir.threads.soketExample.processor.DataProcessorV2;
import de.kozdemir.threads.soketExample.soket.SoketV2;

public class ClientStarterV2 {

	public static void main(String[] args) {
		Thread thread = new Thread(new SoketV2(),"Client");
		thread.start();
		Thread dataProcessor = new Thread(new DataProcessorV2(),"Data Processor");
		dataProcessor.start();
	}
}
