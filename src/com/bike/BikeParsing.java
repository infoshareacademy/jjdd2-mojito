package com.bike;

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

    public BikeParsing(String fileName) {
        this.fileName = fileName;
        cityList = new ArrayList<City>();
    }

    public void parseData() throws ParserConfigurationException, SAXException, IOException{
        File inputFile = new File(fileName);
        DocumentBuilderFactory dbFaktory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuilder = dbFaktory.newDocumentBuilder();
        Document doc = dbBuilder.parse(inputFile);

        NodeList cityNodeList = doc.getElementsByTagName("city");
        for (int i = 0; i < cityNodeList.getLength(); i++) {
            Node cityNode = cityNodeList.item(i);
            if (cityNode.getNodeType() == Node.ELEMENT_NODE) {
                Element cityElement = (Element)cityNode;
                String cityName = cityElement.getAttribute("name");
                String cityLat = cityElement.getAttribute("lat");
                String cityLong = cityElement.getAttribute("lng");
                City city = new City(cityLat, cityLong, cityName);

                NodeList placeNodeList = cityElement.getElementsByTagName("place");
                for (int j = 0; j < placeNodeList.getLength(); j++) {
                    Node placeNode = placeNodeList.item(j);
                    if (placeNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element placeElement = (Element)placeNode;

                        //dodanie parsowania dwoch nowych pol - lng i lat
                        //tak samo jako "name" i przekazanie ich do konstruktora
                        String placeName = placeElement.getAttribute("name");
//                        String placeLat = placeElement.getAttribute("lat");
//                        String placeLng = placeElement.getAttribute("lng");
//                        Place place = new Place(placeName, placeLat);
                        city.getPlaceList().add(place);

                    }
                }
                cityList.add(city);
            }
        }
    }

    public void showData() {

        for (int i = 0; i < cityList.size(); i++){
            City city = cityList.get(i);
            System.out.println("Miasto " + city.getName() + " " + city.getLatitude() + " " + city.getLongitude());
            for (int j = 0; j < city.getPlaceList().size(); j++) {
                Place place = city.getPlaceList().get(j);
                //wyswietlenie nowych danych - lat i lng
                System.out.println("\t" + "Miejsce " + place.getName());
            }
        }
    }
}
