package proc;

import oasis.Connector;
import oasis.CustomShape;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by user on 23.02.17.
 */
public class ExtractGraphHandler extends DefaultHandler {
    private ArrayList<Connector> connectors = new ArrayList<>();
    private TreeMap<String, CustomShape> customShapes = new TreeMap<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            int i1 = Integer.parseInt(o1.replaceAll("id",""));
            int i2 = Integer.parseInt(o2.replaceAll("id",""));
            return i1 - i2;
        }
    });

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("draw")) {
            if(localName.equals("connector")) {
                connectors.add(new Connector());
            }
        }
    }
}
