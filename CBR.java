
public class CBR {
	public static void main(String[] args){
		CBRC Test = new CBRC("TRAVEL.csv");
		System.out.println(Test.DataArr.size());
		System.out.println(Test.DataArr.get(Test.CountCBR("Skiing", 589, 100, "Plane", 7, "January").get(2).getKey()).CaseName);
	}
}
