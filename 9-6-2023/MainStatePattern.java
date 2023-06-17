package com.dal.StatePattern;

interface State{
	void TrafficLightStateChange(LightSwitch lightswitch);
}
class LightSwitch{
	private State state;
	private boolean lightstate = false;
	public void SetState(State state) {
		this.state = state;
	}
	public State getState() {
		return this.state;
	}
	public void LightStateChange() {
		if(lightstate)
		{
			lightstate = false;
			this.state = new LightOFF();
			state.TrafficLightStateChange(this);
	
		}
		else
		{
			lightstate = true;
			this.state = new LightON();
			state.TrafficLightStateChange(this);
		
		}
		
	}
	
}
class LightON implements State{
	 public void TrafficLightStateChange(LightSwitch lightswitch) {
		 lightswitch.SetState(new LightOFF());
		 System.out.println("Light Switch ON");
	}
	
}
class LightOFF implements State{
	public void TrafficLightStateChange(LightSwitch lightswitch) {
		 lightswitch.SetState(new LightON());
		 System.out.println("Light Switch OFF");
	}
}
public class MainStatePattern {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		LightSwitch ls = new LightSwitch();
	    ls.LightStateChange();
	    Thread.sleep(1000);
	    ls.LightStateChange();
	    Thread.sleep(1000);
	    ls.LightStateChange();
	}

}
