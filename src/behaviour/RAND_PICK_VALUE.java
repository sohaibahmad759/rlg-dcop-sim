package behaviour;

import jade.core.behaviours.OneShotBehaviour;

import java.util.ArrayList;
import java.util.Random;

import agent.DCOP;

public class RAND_PICK_VALUE extends OneShotBehaviour {

	private static final long serialVersionUID = -6711542619242113965L;

	DCOP agent;
	
	public RAND_PICK_VALUE(DCOP agent) {
		super(agent);
		this.agent = agent;
	}
	
	@Override
	public void action() {
		agent.setCurrentStartTime(agent.getBean().getCurrentThreadUserTime());
		
		ArrayList<String> domain = agent.getDecisionVariableDomainMap().get(agent.getIdStr());
		int domainSize = domain.size();
		Random rdn = new Random();
		if (agent.phase == DCOP.FIRST_PHASE) {
			for (int ts=0; ts<=1; ts++) {
				agent.getValueAtEachTSMap().put(ts,domain.get(rdn.nextInt(domainSize)));
			}
		}
		else if (agent.phase == DCOP.SECOND_PHASE) {
			for (int ts=2; ts<=3; ts++) {
				agent.getValueAtEachTSMap().put(ts,domain.get(rdn.nextInt(domainSize)));
			}
		}
		
		agent.setSimulatedTime(agent.getSimulatedTime()
							+ agent.getBean().getCurrentThreadUserTime() - agent.getCurrentStartTime());
	}
}
