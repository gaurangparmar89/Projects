package DistCalculator;

public class GeoLocations 
{
	private double latitude, longitude;
	public GeoLocations() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public GeoLocations(double latitude, double longitude) 
	{
		this.latitude = latitude;
		this.longitude = longitude;
	}
	

	public double getLatitude() 
	{
		return latitude;
	}

	public void setLatitude(double latitude) 
	{
		this.latitude = latitude;
	}

	public double getLongitude() 
	{
		return longitude;
	}

	public void setLongitude(double longitude) 
	{
		this.longitude = longitude;
	}
	
}
