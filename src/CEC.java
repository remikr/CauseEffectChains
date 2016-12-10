import java.util.ArrayList;
import java.util.List;

import fr.univ_lille1.m2iagl.dd.CauseEffectChain;
import fr.univ_lille1.m2iagl.dd.ChainElement;

public class CEC implements CauseEffectChain {

	public List<ChainElement> chain;
	
	public CEC() {
		chain = new ArrayList<ChainElement>();
	}
	
	@Override
	public List<ChainElement> getChain() {
		return chain;
	}

}
