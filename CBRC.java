import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class CBRC {
	static ArrayList<TrapData> DataArr = new ArrayList<>();
	static HashSet<String> HTset = new HashSet<String>();
	static ArrayList<String> HT;
	static HashSet<String> TTset = new HashSet<>();
	static ArrayList<String> TT;
	static HashSet<String> Seasonset = new HashSet<>();
	static ArrayList<String> Season;
	CBRC(String filename){
		DealFile(filename);
	}

	public static void DealFile(String filename){
		try {
			FileReader fr=new FileReader(filename);
			BufferedReader br=new BufferedReader(fr);
			while(br.ready()){
				String t = br.readLine();
				if(!t.equals("")){
					String in;
					TrapData TD = new TrapData();
					TD.CaseName =t;
					in = br.readLine();
					TD.TripCode = Integer.parseInt(in);
					in = br.readLine().replace("\"","").replace(",","");
					HTset.add(in);
					TD.HolidayType = in;
					in = br.readLine();
					TD.Price = Integer.parseInt(in);
					in = br.readLine();
					TD.NumberOfPersons = Integer.parseInt(in);
					in = br.readLine().replace("\"","").replace(",","");
					TD.Region = in;
					in = br.readLine().replace("\"","").replace(",","");
					TTset.add(in);
					TD.Transportation = in;
					in = br.readLine();
					TD.Duration = Integer.parseInt(in);
					in = br.readLine().replace("\"","").replace(",","");
					Seasonset.add(in);
					TD.Season = in;
					in = br.readLine().replace("\"","").replace(",","");
					TD.Acc = in;
					in = br.readLine().replace("\"","");
					TD.Hotel =in;
					DataArr.add(TD);
				}
			}
			br.close();
			HT = new ArrayList<String>(HTset);
			TT = new ArrayList<String>(TTset);
			Season = new ArrayList<String>(Seasonset);
		} 
		catch (IOException e) {System.out.println(e);}
	}
	public static void CountCBR(){
		
	}
}
