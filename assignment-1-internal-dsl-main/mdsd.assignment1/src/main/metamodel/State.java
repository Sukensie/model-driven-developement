package main.metamodel;

import java.util.ArrayList;
import java.util.List;

public class State {
	
	private String name;
	private List<Transition> transitions = new ArrayList<>();
	
	public State(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	
	public void addTransition(Transition t) {
		this.transitions.add(t);
	}
	
	public void removeTransition(Transition t) {
		this.transitions.remove(t);
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

	public Transition getTransitionByEvent(String string) {				
		Transition latestMatch = null;
		
		for (Transition t : transitions) {
			if (t.getEvent().equals(string)) {
				latestMatch = t;
			}
		}
		
		return latestMatch;
	}
}


