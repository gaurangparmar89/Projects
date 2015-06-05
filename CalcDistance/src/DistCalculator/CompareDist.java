package DistCalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CompareDist 
{

	public CompareDist() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String args[])
	{
		HashMap<String,Double> dist = new HashMap<String,Double>();
		
		GeoLocations a = new GeoLocations(30,15);
		GeoLocations b = new GeoLocations(35,20);
		GeoLocations c = new GeoLocations(50,10);
		GeoLocations d = new GeoLocations(70,20);
		
		HashMap<String,GeoLocations> point = new HashMap<String, GeoLocations>();
		point.put("A", a);
		point.put("B", b);
		point.put("C", c);
		point.put("D", d);
		
		ArrayList<String> possibledetours= new ArrayList<String>();
		possibledetours.add("ABCD");
		possibledetours.add("CABD");
		
		for(String route: possibledetours)
		{
			double totaldist = 0;
			for(int i=0; i<route.length() - 2;i++)
			{
				String source = String.valueOf(route.charAt(i));
				String dest = String.valueOf(route.charAt(i + 1));
				
				totaldist = totaldist + calcDist(point.get(source),point.get(dest));
			}
			dist.put(route,totaldist);
		}
		
		
		Set<Entry<String, Double>> entryset = dist.entrySet();
		Iterator it = entryset.iterator();
		
		double minDist = Double.MAX_VALUE;
		String detour_route = "";
		
		while(it.hasNext())
		{
			Map.Entry<String, Double> entry = (Map.Entry<String,Double>) it.next();
			if(entry.getValue() < minDist)
			{
				// System.out.println(entry.getKey());
				minDist = entry.getValue();
				detour_route = entry.getKey();
			}
		}
		
		System.out.println("Route is " + detour_route);
		System.out.println("Dist is " + minDist);
	
	}
	
	public static double calcDist(GeoLocations source, GeoLocations dest)
	{
		double dist = 0;
		double R = 3961; // in miles
		
		double difflong = source.getLongitude() - dest.getLongitude();
		double difflat = source.getLatitude() - dest.getLatitude();
		
		double a = Math.pow(Math.sin(difflat/2), 2) 
				 + Math.cos(source.getLatitude()) * Math.cos(dest.getLatitude())
				 + Math.pow(Math.sin(difflong/2), 2);
		
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		dist = R * c;
		
		return dist;
	}
}
