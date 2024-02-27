package main.metamodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Machine {
	
	private List<State> states = new ArrayList<State>();
	private State initialState;
	private Map<String,Integer> variables = new HashMap<>();


	
	public Machine(Collection<State> states, State initialState, Map<String, Integer> variables) {
		this.states.addAll(states);
		this.initialState = initialState;
		this.variables.putAll(variables);
	}

	public List<State> getStates() {
		return states;
	}
	
	public State getInitialState() {
		return initialState;
	}

	public State getState(String string) {
		// loop through states and return one matching parameter
		for (State s : states) {
			if (s.getName().equals(string)) {
				return s;
			}
		}
		return null;
	}

	public int numberOfIntegers() {
		return variables.size();
	}

	public boolean hasInteger(String string) {
        return variables.containsKey(string);

	}
	
	public int getVariable(String string) {
		return variables.get(string);
	}
	
	public void setVariable(String name, Integer value) {
		if (!variables.containsKey(name)) variables.put(name, 0);
		else variables.put(name, value);
	}
		
		
}

