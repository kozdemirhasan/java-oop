package de.kozdemir.threads.soketExample.processor;


import java.text.MessageFormat;
import java.util.Calendar;

import de.kozdemir.threads.soketExample.entity.LabeledEntity;
import de.kozdemir.threads.soketExample.enums.DataType;
import de.kozdemir.threads.soketExample.queue.DataQueue;

public class DataProcessorV2 implements Runnable{

	@Override
	public void run() {
		while(true) {
			try {
				String data = DataQueue.take();
				proceedData(data);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
	
	private void proceedData(String data) {
		
		try {
			Thread.sleep(2000);
			String[] dataParts = data.split(",");
			LabeledEntity entity = null;
			if(dataParts.length == 3) {
				System.out.println("X Veri Tipi");
				entity = new LabeledEntity(data,DataType.X);
			} else if(dataParts.length == 4) {
				System.out.println("Y Veri Tipi");
				entity = new LabeledEntity(data,DataType.Y);
			} else if(dataParts.length == 5) {
				System.out.println("Z Veri Tipi");
				entity = new LabeledEntity(data,DataType.Z);
			} else {
				System.out.println("Bilinmeyen ");
			}
			System.out.println(MessageFormat.format("{0} islendi. Saniye: {1}", data,Calendar.getInstance().get(Calendar.SECOND)));
 		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
