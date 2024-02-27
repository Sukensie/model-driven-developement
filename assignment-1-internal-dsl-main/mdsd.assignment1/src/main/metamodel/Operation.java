package main.metamodel;

public class Operation {
	private String variableName;
	private String type;
	private Integer value;
	
	public Operation(String variableName, String type, Integer value) {
		this.variableName = variableName;
		this.type = type;
		this.value = value;
	}
	
	public String getVariableName() {
		return variableName;
	}
	
	public String getType() {
		return type;
	}
	
	public Integer getValue() {
		return value;
	}

}


