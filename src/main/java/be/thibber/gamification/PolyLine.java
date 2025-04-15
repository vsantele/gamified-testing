package be.thibber.gamification;

import java.util.List;

/**
 * Polyline is a series of connected points.
 */
abstract class PolyLine {
    private List<Coords> points;

    /**
     * Constructor of a polyline.
     * Polyline is a series of connected points.
     * @param points points of the polyline
     */
    public PolyLine(List<Coords> points) {
        if(points == null || points.size() < 2) {
            throw new IllegalArgumentException("A polyline must have at least 2 points");
        }

        setPoints(points);
    }

    /**
     * @return length of polyline
     */
    public double getLength(){
        double length = 0;

        for (int i = 0; i < points.size() - 1; i++) {
            length += points.get(i).getDistanceTo(points.get(i + 1));
        }

        return length;
    }

    /**
     * @return road points
     */
    public List<Coords> getPoints() {
        return points;
    }

    /**
     * @param points of the new road points
     */
    public void setPoints(List<Coords> points) {
        this.points = points;
    }

    /**
     * @param point Point to add at the end of the polyline
     */
    public void appendPoint(Coords point) {
        if(point == null) {
            throw new IllegalArgumentException("Polyline point cannot be null");
        }

        points.add(point);
    }

    /**
     * @return Get the maximum segment length of the polyline
     */
    public double getMaximumSegmentLength(){
        double maxLength = Double.MIN_VALUE;

        for (int i = 0; i < points.size() - 1; i++) {
            double length = points.get(i).getDistanceTo(points.get(i + 1));

            if(length > maxLength) {
                maxLength = length;
            }
        }

        return maxLength;
    }

    /**
     * Move all points of the polyline by the specified offsets.
     * @param xOffset X offset to add to this
     * @param yOffset Y offset to add to this
     */
    public void move(double xOffset, double yOffset) {
        for (Coords point : points) {
            point.move(xOffset, yOffset);
        }
    }
}
