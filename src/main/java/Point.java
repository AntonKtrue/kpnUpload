/**
 * Created by user on 01.04.17.
 */
public class Point {
    private String id;
    private String name;
    private String description;
    private int type;
    private int mpsa_id;
    private int local_id;
    private int position;

    public Point(String id, String name, String description) {
        this.id = id;
        this.name = name.trim();
        this.description = description;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", mpsa_id=" + mpsa_id +
                ", local_id=" + local_id +
                ", position=" + position +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMpsa_id() {
        return mpsa_id;
    }

    public void setMpsa_id(int mpsa_id) {
        this.mpsa_id = mpsa_id;
    }

    public int getLocal_id() {
        return local_id;
    }

    public void setLocal_id(int local_id) {
        this.local_id = local_id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
