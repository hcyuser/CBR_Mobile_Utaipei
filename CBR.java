
public class CBR {
	public static void main(String[] args){
		CBRC Test = new CBRC("TRAVEL.csv");
		Test.DealFile("TRAVEL.csv");
		System.out.println(Test.Season.indexOf("July"));
		
		
		
	}
}
