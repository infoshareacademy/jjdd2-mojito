import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class wspolrzednaMiasto {

    public static void main(String argv[]) {
        try {
            File file = new File("nextbike-live.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            System.out.println("Element główny:"
                    + doc.getDocumentElement().getNodeName());

            NodeList nodeLst = doc.getElementsByTagName("country");

            for (int s = 0; s < nodeLst.getLength(); s++) {

                Node fstNode = nodeLst.item(s);
                if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element fstElmnt = (Element) fstNode;

                    NodeList fstNmElmntLst = fstElmnt
                            .getElementsByTagName("lat");

                    Element fstNmElmnt = (Element) fstNmElmntLst.item(0);

                    NodeList fstNm = fstNmElmnt.getChildNodes();


                    NodeList lstNmElmntLst = fstElmnt
                            .getElementsByTagName("lng");

                    Element lstNmElmnt = (Element) lstNmElmntLst.item(0);

                    NodeList lstNm = lstNmElmnt.getChildNodes();


                    System.out.println("\n***");

                    System.out.println("Atrybut country: "
                            + fstElmnt.getAttribute("country"));

                    System.out.println("Element lat : "
                            + ((Node) fstNm.item(0)).getNodeValue());

                    System.out.println("Element lng : "
                            + ((Node) lstNm.item(0)).getNodeValue());

                }


            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
