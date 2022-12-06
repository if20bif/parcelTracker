package at.fhtw.swen3.service;

import fr.dudie.nominatim.model.Address;
import org.locationtech.jts.geom.Point;

import java.io.IOException;

public interface GeoEncodingService {
    Point encodeAddress(String s) throws IOException;
    String decodeAddress(Point p) throws IOException;
}
