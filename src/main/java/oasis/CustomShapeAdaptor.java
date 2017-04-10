package oasis;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CustomShapeAdaptor extends XmlAdapter<String, CustomShape> {

    @Override
    public CustomShape unmarshal(String v) throws Exception {
        return null;
    }

    @Override
    public String marshal(CustomShape v) throws Exception {
        return null;
    }
}
