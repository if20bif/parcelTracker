package at.fhtw.swen3.service.impl;

import at.fhtw.swen3.service.GeoEncodingService;
import fr.dudie.nominatim.client.NominatimClient;
import fr.dudie.nominatim.client.request.NominatimSearchRequest;
import fr.dudie.nominatim.model.Address;
import org.locationtech.jts.geom.Point;

import java.io.IOException;

public class OSMEncodingProxy implements GeoEncodingService {

    private NominatimClient nominatimClient;

    public Point encodeAddress(Address a) throws IOException {
        /*NominatimSearchRequest req = new NominatimSearchRequest();
        req.setAddress(a);

        return nominatimClient.search(a.toString()).get(0);*/

        return null;
    }


    public Address decodeAddress(Point p) throws IOException {
        return nominatimClient.getAddress(p.getX(), p.getY());
    }
}
