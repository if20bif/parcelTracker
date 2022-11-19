package at.fhtw.swen3.service;

import fr.dudie.nominatim.model.Address;
import org.locationtech.jts.geom.Point;

import java.io.IOException;

public interface GeoEncodingService {
    Point encodeAddress(Address a) throws IOException;
    Address decodeAddress(Point p) throws IOException;
}
