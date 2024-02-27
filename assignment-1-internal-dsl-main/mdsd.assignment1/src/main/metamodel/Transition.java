package main.metamodel;

public class Transition{
	
	private String triggerEventName; //event that triggers the transition
	private State target; // state into the transition goes
	private Condition condition; // condition to be satisfied to perform the transition 
    private Operation operation; // operation to be performed when the transition is executed
	
	
	public Transition(String event, State target, Condition condition, Operation operation) {
		this.triggerEventName = event;
		this.target = target;
		this.condition = condition;
		this.operation = operation;
	}
	
	public Object getEvent() {
		return triggerEventName;
	}

	public State getTarget() {
		return target;
	}
	
	public Operation getOperation() {
		return operation;
	}
	
	public Condition getCondition() {
		return condition;
	}

	public boolean hasSetOperation() {		
		Operation o = operation;
		if( hasOperation() &&  o.getType().equals("set")) return true;
		return false;
	}

	public boolean hasIncrementOperation() {
		Operation o = operation;
		if( hasOperation() && o.getType().equals("increment")) return true;		
		return false;
	}

	public boolean hasDecrementOperation() {
		Operation o = operation;
		if(hasOperation() && o.getType().equals("decrement")) return true;
		return false;
	}

	public String getOperationVariableName() {
		return operation.getVariableName();
	}

	public boolean isConditional() {
		if(condition != null) return true;
		return false;
	}
	
	public void addCondition(Condition c) {
		condition = c;
	}
	
	public void addOperation(Operation o) {
		operation = o;
	}
	
	public String getConditionVariableName() {
		return condition.getVariableName();
	}

	public Integer getConditionComparedValue() {
		return condition.getComparedValue();
	}

	public boolean isConditionEqual() {
		if(condition.getType().equals("equals")) return true;
		return false;
	}

	public boolean isConditionGreaterThan() {
		if(condition.getType().equals("greater")) return true;
		return false;
	}

	public boolean isConditionLessThan() {
		if(condition.getType().equals("less")) return true;
		return false;
	}

	public boolean hasOperation() {
		if(operation != null) return true;
		return false;
	}

}


