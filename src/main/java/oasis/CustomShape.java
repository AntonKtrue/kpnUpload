package oasis;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by user on 23.02.17.
 */
@XmlRootElement(name = "custom-shape", namespace = "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0")
public class CustomShape {

    @XmlAttribute(name = "id", namespace = "http://www.w3.org/XML/1998/namespace")
    @XmlID
    private String id;

    @XmlAttribute(name = "style-name", namespace = "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0")
    private String styleName;

    @XmlAttribute(name = "text-style-name", namespace = "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0")
    private String textStyleName;

    @XmlAttribute(name="layer", namespace = "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0")
    private String layer;

    @XmlAttribute(namespace = "urn:oasis:names:tc:opendocument:xmlns:svg-compatible:1.0")
    private String width;

    @XmlAttribute(namespace = "urn:oasis:names:tc:opendocument:xmlns:svg-compatible:1.0")
    private String height;

    @XmlAttribute(namespace = "urn:oasis:names:tc:opendocument:xmlns:svg-compatible:1.0")
    private String x;

    @XmlAttribute(namespace = "urn:oasis:names:tc:opendocument:xmlns:svg-compatible:1.0")
    private String y;

    @XmlElement(namespace = "urn:oasis:names:tc:opendocument:xmlns:text:1.0", name = "p")
    private String innerText;

}