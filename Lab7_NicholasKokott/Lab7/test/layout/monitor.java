package layout;

import observe.StringObserve;

public class monitor implements StringObserve{

	@Override
	public void update(String d) {
		stuff = d;
	}
	
	private String stuff = "";

	public String getStuff() {
		return stuff;
	}
}
