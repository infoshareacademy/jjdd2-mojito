package infoshareKurs;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BikeParsing {

    private String fileName;

    private List<City> cityList;

    protected List<City> getCityList() {
        return cityList;
    }

    public BikeParsing(String fileName) {
        this.fileName = fileName;
        this.cityList = new ArrayList<City>();
    }

    protected void parseData() throws ParserConfigurationException, SAXException, IOException {

        File inputFile = new File(fileName);
        DocumentBuilderFactory dbFaktory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuilder = dbFaktory.newDocumentBuilder();
        Document doc = dbBuilder.parse(inputFile);
        NodeList countryNodeList = doc.getElementsByTagName("country");
        for (int i = 0; i < countryNodeList.getLength(); i++) {
            Node countryNode = countryNodeList.item(i);
            if (countryNode.getNodeType() == Node.ELEMENT_NODE) {
                Element countryElement = (Element) countryNode;
                String countryName = countryElement.getAttribute("country_name");

                NodeList cityNodeList = countryElement.getElementsByTagName("city");
                for (int k = 0; k < cityNodeList.getLength(); k++) {
                    Node cityNode = cityNodeList.item(k);
                    if (cityNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element cityElement = (Element) cityNode;

                        String cityName = cityElement.getAttribute("name");
                        String cityLat = cityElement.getAttribute("lat");
                        String cityLong = cityElement.getAttribute("lng");

                        double cityLatDouble = 0.0;
                        double cityLngDouble = 0.0;
                        if (!cityLat.isEmpty()) {
                            cityLatDouble = Double.parseDouble(cityLat);
                        }
                        if (!cityLong.isEmpty()) {
                            cityLngDouble = Double.parseDouble(cityLong);
                        }
                        City city = new City(cityLatDouble, cityLngDouble, cityName, countryName);
                        cityList.add(city);

                        NodeList placeNodeList = cityElement.getElementsByTagName("place");
                        for (int j = 0; j < placeNodeList.getLength(); j++) {
                            Node placeNode = placeNodeList.item(j);
                            if (placeNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element placeElement = (Element) placeNode;

                                String placeName = placeElement.getAttribute("name");
                                String placeLat = placeElement.getAttribute("lat");
                                String placeLng = placeElement.getAttribute("lng");

                                double placeLatDouble = 0.0;
                                double placeLngDouble = 0.0;
                                if (!placeLat.isEmpty()) {
                                    placeLatDouble = Double.parseDouble(placeLat);
                                }
                                if (!placeLng.isEmpty()) {
                                    placeLngDouble = Double.parseDouble(placeLng);
                                }
                                Place place = new Place(placeName, placeLatDouble, placeLngDouble);
                                city.getPlaceList().add(place);

                            }
                        }
                    }
                }
            }
        }
    }
}
