
public class Edge {

	String roadID;
	Vertex v1;
	Vertex v2;
	double dist;

	public Edge(String roadID, Vertex v1, Vertex v2) {
		this.roadID = roadID;
		this.v1 = v1;
		this.v2 = v2;
		dist = haversine(v1.latt,v1.lon,v2.latt,v2.lon);
	}
	
	public String toString() {
		return "ID: " + roadID + ", from " + v1.id + " to " + v2.id;
	}
	
	  public static final double R = 6372.8; // In kilometers
	    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
	        double dLat = Math.toRadians(lat2 - lat1);
	        double dLon = Math.toRadians(lon2 - lon1);
	        lat1 = Math.toRadians(lat1);
	        lat2 = Math.toRadians(lat2);
	 
	        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
	        double c = 2 * Math.asin(Math.sqrt(a));
	        return R * c;
	    }
	
}
