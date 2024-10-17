package libs;

public class TennisCoach implements Coach{
	private FortuneService theFortune;
	
	public TennisCoach(FortuneService theFortune) {
		this.theFortune = theFortune;
	}

	@Override
	public String getDailyWorkout() {
		return "TennisCoach: Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return theFortune.getFortune();
	}
	

}
