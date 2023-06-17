package Exercise1;

interface IHealthRecord{
	public String GetRecordToCite();
}

class HealthRecordFactory {
	public IHealthRecord GetHealthObject(String HealthObjectType) {
		if(HealthObjectType == null) return null;
		else if (HealthObjectType.equalsIgnoreCase("Problem"))
			return new Problem();
		else if (HealthObjectType.equalsIgnoreCase("Allergy"))
			return new Allergy();
		else if (HealthObjectType.equalsIgnoreCase("Alert"))
			return new Alert();
		return null;
	}
}
class Problem implements IHealthRecord{
	public String GetRecordToCite() {
		return "Problem health record";
	}
}
class Allergy implements IHealthRecord{
	public String GetRecordToCite() {
		return "Allergy health record";
	}
}
class Alert implements IHealthRecord{
	public String GetRecordToCite() {
		return "Alert health record";
	}
}
public class FactoryPatternEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HealthRecordFactory hrf = new HealthRecordFactory();
		IHealthRecord hr = hrf.GetHealthObject("Problem");
		System.out.println(hr.GetRecordToCite());
		hr = hrf.GetHealthObject("Allergy");
		System.out.println(hr.GetRecordToCite());
		hr = hrf.GetHealthObject("Alert");
		System.out.println(hr.GetRecordToCite());
	}

}
