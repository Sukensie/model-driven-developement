package main.metamodel;

public class Condition {
	private String variableName;
	private String type;
	private int comparedValue;
	
	public Condition(String variableName, String type, int comparedValue) {
		this.variableName = variableName;
		this.type = type;
		this.comparedValue = comparedValue;
	}
	
	public String getVariableName() {
		return variableName;
	}
	
	public String getType() {
		return type;
	}
	
	public int getComparedValue() {
		return comparedValue;
	}
}
