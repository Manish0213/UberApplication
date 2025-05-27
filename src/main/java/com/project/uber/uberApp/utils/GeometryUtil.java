package com.project.uber.uberApp.utils;

import com.project.uber.uberApp.dto.PointDto;
import org.locationtech.jts.geom.*;

public class GeometryUtil {

    public static Point createPoint(PointDto pointDto) {
        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);

        double x = pointDto.getCoordinates()[0];
        double y = pointDto.getCoordinates()[1];

        Coordinate coordinate = new Coordinate(x,y);
        return geometryFactory.createPoint(coordinate);
    }
}
