/**
 * Created by user on 01.04.17.
 */
public class Ray {
    private Point start;
    private Point end;

    private int mpsa_id;
    private int mpsa_start;
    private int mpsa_end;

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public int getMpsa_id() {
        return mpsa_id;
    }

    public void setMpsa_id(int mpsa_id) {
        this.mpsa_id = mpsa_id;
    }

    public int getMpsa_start() {
        return mpsa_start;
    }

    public void setMpsa_start(int mpsa_start) {
        this.mpsa_start = mpsa_start;
    }

    public int getMpsa_end() {
        return mpsa_end;
    }

    public void setMpsa_end(int mpsa_end) {
        this.mpsa_end = mpsa_end;
    }

    public Ray(Point start, Point end) {
        this.start = start;
        this.end = end;
    }



    @Override
    public String toString() {
        return "Ray{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
