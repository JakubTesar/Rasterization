package cz.educanet.tranformations.logic;

import cz.educanet.tranformations.logic.models.Coordinate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ScreenManager {

    private Set<Coordinate> selectedPoints = new HashSet<>();

    public void select(Coordinate coordinate) {
        selectedPoints.add(coordinate);
    }

    public void unselect(Coordinate coordinate) {
        selectedPoints.remove(coordinate);
    }

    public boolean isSelected(Coordinate coordinate) {
        return selectedPoints.contains(coordinate);
    }

    public Set<Coordinate> getSelectedPoints() {
        return selectedPoints;
    }

    public boolean isFilledIn(Coordinate coordinate) { // TODO: Implement this

        if (selectedPoints.size() < 3) {
            return false;
        }

        Coordinate[] coords = selectedPoints.toArray(new Coordinate[]{});

        Coordinate bod1 = coords[0];
        Coordinate bod2 = coords[1];
        Coordinate bod3 = coords[2];

        double a1 = 0;
        double b1 = 0;
        double y1 = 0;

        double a2 = 0;
        double b2 = 0;

        double a3 = 0;
        double b3 = 0;

        double Y1 = bod1.getY();
        double X1 = bod1.getX();
        double Y2 = bod2.getY();
        double X2 = bod2.getX();
        double Y3 = bod3.getY();
        double X3 = bod3.getX();

        boolean jedna = false;
        boolean dva = false;
        boolean tri = false;

        a1 = (Y2 - Y1) / (X2 - X1);
        b1 = Y1 - (a1 * X1);
        y1 = a1 * X1 + b1;

        a2 = (Y3 - Y2) / (X3 - X2);
        b2 = Y2 - (a2 * X2);

        a3 = (Y1 - Y3) / (X1 - X3);
        b3 = Y3 - (a3 * X3);


        if (Y3 > a1 * X3 + b1) {
            if (coordinate.getY() > a1 * coordinate.getX() + b1)
                jedna = true;
            else
                jedna = false;
        }

        if (Y3 < a1 * X3 + b1) {
            if (coordinate.getY() < a1 * coordinate.getX() + b1)
                jedna = true;
            else
                jedna = false;
        }


        if (Y1 > a2 * X1 + b2) {
            if (coordinate.getY() > a2 * coordinate.getX() + b2)
                dva = true;
            else
                dva = false;
        }

        if (Y1 < a2 * X1 + b2) {
            if (coordinate.getY() < a2 * coordinate.getX() + b2)
                dva = true;
            else
                dva = false;
        }


        if (Y2 > a3 * X2 + b3) {
            if (coordinate.getY() > a3 * coordinate.getX() + b3)
                tri = true;
            else
                tri = false;
        }

        if (Y2 < a3 * X2 + b3) {
            if (coordinate.getY() < a3 * coordinate.getX() + b3)
                tri = true;
            else
                tri = false;
        }


        if (jedna && dva && tri) {
            return true;
        }

        return false;
    }
}
