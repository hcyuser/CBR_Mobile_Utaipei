package com.example.changhsinjung.trivago;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;


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
	public static List<Map.Entry<Integer,Double>> CountCBR(String HTLV,int price,int person,String TTLV,int DurationLV,String SeasonLV){
		HashMap<Integer,Double> Rank = new HashMap<>();
		for(int i=0;i<DataArr.size();i++){
			Double totalScore = Math.sqrt(Math.pow(HT.indexOf(HTLV)-HT.indexOf(DataArr.get(i).HolidayType), 2)+Math.pow(price-DataArr.get(i).Price, 2)
			+Math.pow(person-DataArr.get(i).NumberOfPersons,2)+Math.pow(TT.indexOf(TTLV)-TT.indexOf(DataArr.get(i).Transportation), 2)+Math.pow(DataArr.get(i).Duration-DurationLV, 2)+Math.pow(Season.indexOf(SeasonLV)-Season.indexOf(DataArr.get(i).Season), 2));
			Rank.put(i, totalScore);
		}
		List<Map.Entry<Integer,Double>> mylist = new ArrayList<Map.Entry<Integer,Double>>(Rank.entrySet());
		//然后通过比较器来实现排序
		Collections.sort(mylist,new Comparator<Map.Entry<Integer,Double>>() {
			//升序排序
			public int compare(Entry<Integer,Double> o1, Entry<Integer,Double> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}

		});
		return mylist;
	}
}
