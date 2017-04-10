
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by user on 23.02.17.
 */
public class Loader {
    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("main.xml");
//        JFrame jFrame = (JFrame) ctx.getBean("mainWindow");
//        SwingUtilities.invokeLater(()->{
//            jFrame.setVisible(true);
//        });
        ApplicationContext ctx = new ClassPathXmlApplicationContext("out.xml");

        LinkedList<Point> points = new LinkedList<>((ArrayList<Point>) ctx.getBean("points"));
        LinkedList<Ray> rays = new LinkedList<>((ArrayList<Ray>) ctx.getBean("rays"));

        cleanGraph(points, rays);
        bindPointTypes(points);

        int i = 0;
        for(Ray ray : rays) {
            System.out.println(++i + " " + ray);
        }
        for(Point point : points) {
            System.out.println(point);
        }
    }

    private static void cleanGraph(LinkedList<Point> points, LinkedList<Ray> rays) {
        Iterator<Point> pointIterator = points.iterator();
        while (pointIterator.hasNext()) {
            Point point = pointIterator.next();
            if(point.getName().matches("^U.*")) {
                ArrayList<Point> starts = new ArrayList<>();
                ArrayList<Point> ends = new ArrayList<>();
                pointIterator.remove();
                Iterator<Ray> rayIterator = rays.iterator();
                while (rayIterator.hasNext()) {
                    Ray ray = rayIterator.next();
                    if(ray.getStart() == point) {
                        ends.add(ray.getEnd());
                        rayIterator.remove();
                    } else if (ray.getEnd() == point) {
                        starts.add(ray.getStart());
                        rayIterator.remove();
                    }
                }
                for(Point start : starts) {
                    for (Point end : ends) {
                        if(start != end)
                            rays.add(new Ray(start, end));
                    }
                }
            }
        }
    }

    private static void bindPointTypes(LinkedList<Point> points) {
        for(Point point : points) {
            if(point.getName().matches("^Z.*")) {
                point.setType(1);
            } else if(point.getName().matches("^R.*")) {
                point.setType(2);
            } else if(point.getName().matches("^MNA.*")) {
                point.setType(3);
            } else if(point.getName().matches("^PNA.*")) {
                point.setType(4);
            } else if(point.getName().matches("^Ki.*")) {
                point.setType(5);
            } else if(point.getName().matches("^Ko.*")) {
                point.setType(6);
            } else if(point.getName().matches("^S-.*")) {
                point.setType(7);
            } else if(point.getName().matches("^KPP.*")) {
                point.setType(8);
            } else if(point.getName().matches("^KIP.*")) {
                point.setType(9);
            } else if(point.getName().matches("^SAR.*")) {
                point.setType(10);
            } else if(point.getName().matches("^NSI-MNS.*")) {
                point.setType(11);
            } else if(point.getName().matches("^NSO.*")) {
                point.setType(12);
            } else if(point.getName().matches("^NSI-PNS.*")) {
                point.setType(13);
            } else if(point.getName().matches("^BN-.*")) {
                point.setType(14);
            } else if(point.getName().matches("^MPSA.*")) {
                point.setType(99);
            }
        }
    }
}
