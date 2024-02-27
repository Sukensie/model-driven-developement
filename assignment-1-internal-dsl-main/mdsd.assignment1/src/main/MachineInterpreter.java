package main;

import main.metamodel.Condition;
import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;
import main.metamodel.Operation;

public class MachineInterpreter {
	
	private Machine machine;
	private State currentState; 
		
    public void run(Machine m) {
    	machine = m;
    	currentState = machine.getInitialState();
    }

    public State getCurrentState() {
    	return machine.getState(currentState.getName());
    }

    public void processEvent(String string) {
    	
    	for(Transition t: currentState.getTransitions()) {
   			if(t.getEvent().equals(string)) {
				
				if (t.isConditional()) {
					Condition c = t.getCondition();
					
					if (t.isConditionEqual()) {
						if (c.getComparedValue() != machine.getVariable(c.getVariableName())) {
							continue;
						}
					}
					
					else if (t.isConditionGreaterThan()) {
						if (!(machine.getVariable(c.getVariableName()) > c.getComparedValue())) {
							continue;
						}
					}
					
					else if (t.isConditionLessThan()) {
						if (!(machine.getVariable(c.getVariableName()) < c.getComparedValue())) {
							continue;
						}
					}
				}
				
				
				if (t.hasOperation()) {
				    Operation o = t.getOperation();			
				    Integer currentVariableValue = machine.getVariable(o.getVariableName());

					if (t.hasDecrementOperation()) {
						machine.setVariable(o.getVariableName(), currentVariableValue-1);
					}

					else if (t.hasIncrementOperation()) {
						machine.setVariable(o.getVariableName(), currentVariableValue+1);
					}
					
					else if (t.hasSetOperation()) {
						machine.setVariable(o.getVariableName(), o.getValue());
					}
					    
				}
				
				
				currentState = t.getTarget();
				return;
			}
		}
    }

    public int getInteger(String string) {
		if(machine.hasInteger(string)) return machine.getVariable(string);
        return 0;
    }

}


