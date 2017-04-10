package oasis;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "custom-shape", namespace = "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0")
public class Connector {

    @XmlAttribute(name="style-name", namespace =  "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0")
    private String styleName;

    @XmlAttribute(name="text-style-name", namespace =  "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0")
    private String textStyleName;

    @XmlAttribute(name="layer", namespace =  "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0")
    private String layer;

    @XmlAttribute(name="x1", namespace = "urn:oasis:names:tc:opendocument:xmlns:svg-compatible:1.0")
    private String x1;

    @XmlAttribute(name="y1", namespace = "urn:oasis:names:tc:opendocument:xmlns:svg-compatible:1.0")
    private String y1;

    @XmlAttribute(name="x2", namespace = "urn:oasis:names:tc:opendocument:xmlns:svg-compatible:1.0")
    private String x2;

    @XmlAttribute(name="y2", namespace = "urn:oasis:names:tc:opendocument:xmlns:svg-compatible:1.0")
    private String y2;

    @XmlJavaTypeAdapter(CustomShapeAdaptor.class)
    @XmlAttribute(name="start-shape", namespace =  "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0")
    private CustomShape startShape;

    @XmlAttribute(name="start-glue-point", namespace =  "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0")
    private String startGluePoint;

    @XmlJavaTypeAdapter(CustomShapeAdaptor.class)
    @XmlAttribute(name="end-shape", namespace =  "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0")
    private CustomShape endShape;

    @XmlAttribute(name="end-glue-point", namespace =  "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0")
    private String endGluePoint;

    @XmlAttribute(name="d", namespace = "urn:oasis:names:tc:opendocument:xmlns:svg-compatible:1.0")
    private String d;

    @XmlAttribute(name="d", namespace = "urn:oasis:names:tc:opendocument:xmlns:svg-compatible:1.0")
    private String viewBox;

    @Override
    public String toString() {
        return "Connector{" +
                "styleName='" + styleName + '\'' +
                ", textStyleName='" + textStyleName + '\'' +
                ", layer='" + layer + '\'' +
                ", x1='" + x1 + '\'' +
                ", y1='" + y1 + '\'' +
                ", x2='" + x2 + '\'' +
                ", y2='" + y2 + '\'' +
                ", startShape=" + startShape +
                ", startGluePoint='" + startGluePoint + '\'' +
                ", endShape=" + endShape +
                ", endGluePoint='" + endGluePoint + '\'' +
                ", d='" + d + '\'' +
                ", viewBox='" + viewBox + '\'' +
                '}';
    }
}
