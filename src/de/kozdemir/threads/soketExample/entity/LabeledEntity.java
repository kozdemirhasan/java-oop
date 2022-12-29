

package de.kozdemir.threads.soketExample.entity;

import de.kozdemir.threads.soketExample.enums.DataType;

public class LabeledEntity {

	private String data;
	
	private DataType dataType;

	public LabeledEntity(String data, DataType dataType) {
		this.data = data;
		this.dataType = dataType;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
	
}
