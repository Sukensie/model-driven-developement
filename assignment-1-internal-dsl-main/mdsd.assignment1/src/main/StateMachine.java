package main;

import java.util.HashMap;
import java.util.Map;

import main.metamodel.Condition;
import main.metamodel.Machine;
import main.metamodel.Operation;
import main.metamodel.State;
import main.metamodel.Transition;

public class StateMachine {
	
	private Map<String,State> states = new HashMap<>();
	private Map<String,Integer> variables = new HashMap<>();


	private State current;
	private State initial;
	private String currentEvent;
	
	private State getState(String name) {
		if(!states.containsKey(name)) states.put(name, new State(name));
		return states.get(name);
	}
	
	public Machine build() {
		return new Machine(states.values(),initial, variables); 
	}

	public StateMachine state(String string) {
		current = getState(string);
		return this;
	}

	public StateMachine initial() {
		initial = current;
		return this;
	}

	public StateMachine when(String string) {
		currentEvent = string;
		return this;
	}

	public StateMachine to(String string) {
		Transition t = new Transition(currentEvent,getState(string), null, null);
		current.addTransition(t);
		return this;
	}

	public StateMachine integer(String string) {		
		variables.put(string, 0);
		return this;
	}

	public StateMachine set(String string, int i) {		
		Operation operation = new Operation(string, "set", i);		
	    Transition ct = current.getTransitionByEvent(currentEvent);
		ct.addOperation(operation);
		
		return this;
	}

	public StateMachine increment(String string) {
		Integer currentValue = variables.get(string);
	    
		Operation operation = new Operation(string, "increment", currentValue);		
	    Transition ct = current.getTransitionByEvent(currentEvent);
		ct.addOperation(operation);
	   
		return this;
	}

	public StateMachine decrement(String string) {
		Integer currentValue = variables.get(string);

	    Operation operation = new Operation(string, "decrement", currentValue);		
	    Transition ct = current.getTransitionByEvent(currentEvent);
		ct.addOperation(operation);
	   
		return this;
	}

	public StateMachine ifEquals(String string, int i) {			
		Condition condition = new Condition(string, "equals", i);		
		Transition ct = current.getTransitionByEvent(currentEvent);
		ct.addCondition(condition);
	   
		return this;
	}

	public StateMachine ifGreaterThan(String string, int i) {				
		Condition condition = new Condition(string, "greater", i);		
		Transition ct = current.getTransitionByEvent(currentEvent);
		ct.addCondition(condition);
		
		return this;
	}

	public StateMachine ifLessThan(String string, int i) {		
		Condition condition = new Condition(string, "less", i);		
		Transition ct = current.getTransitionByEvent(currentEvent);
		ct.addCondition(condition);
		
		return this;
	}

}
