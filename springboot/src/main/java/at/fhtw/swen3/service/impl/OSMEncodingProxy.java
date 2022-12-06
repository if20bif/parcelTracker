package at.fhtw.swen3.service.impl;

import at.fhtw.swen3.service.GeoEncodingService;
import fr.dudie.nominatim.client.JsonNominatimClient;
import fr.dudie.nominatim.client.NominatimClient;
import fr.dudie.nominatim.client.request.NominatimSearchRequest;
import fr.dudie.nominatim.model.Address;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

import java.io.IOException;
import java.util.List;

public class OSMEncodingProxy implements GeoEncodingService {

    private NominatimClient nominatimClient;
    private HttpClient httpClient;

    private ClientConnectionManager connectionManager;

    public OSMEncodingProxy(){
        this.httpClient = new DefaultHttpClient(connectionManager, null);

        this.nominatimClient = new JsonNominatimClient("https://nominatim.openstreetmap.org/", this.httpClient, "");
    }

    public Point encodeAddress(String s) throws IOException {

        List<Address> results = nominatimClient.search(s);

        if(results.isEmpty())
            return null;

        GeometryFactory geometryFactory = new GeometryFactory();
        Coordinate coords = new Coordinate(results.get(0).getLongitude(), results.get(0).getLatitude());
        return geometryFactory.createPoint(coords);
    }


    public String decodeAddress(Point p) throws IOException {
        return nominatimClient.getAddress(p.getX(), p.getY()).getDisplayName();
    }
}
