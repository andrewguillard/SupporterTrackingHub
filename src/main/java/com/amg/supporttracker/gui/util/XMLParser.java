package com.amg.supporttracker.gui.util;

import com.amg.supporttracker.gui.util.dto.DonationDTO;
import com.amg.supporttracker.gui.util.dto.PatronDTO;

import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class XMLParser {

    private static String patronsFilePath = "patrons.xml";
    private static String donationsFilePath = "donations.xml";
    private static String configFilePath = "config.xml";
    
    //TODO: Implement this in read and write
    private int maxPatronUserId = 0; //Stores the maximum user id found in the app. This is how we add new ones with unique id.
    private int maxDonationUserId = 0; //Stores the maximum user id found in the app. This is how we add new ones with unique id.

    //Read patrons file and return an array of PatronDTOs
    public static ArrayList<PatronDTO> readPatronsFile(){
        ArrayList<PatronDTO> patrons = new ArrayList<>();

        try {
            System.out.println("Reading Patrons File");
            File patronsFile = new File(patronsFilePath);
            boolean fileExists = patronsFile.exists();
            Document document;

            //If the file doesnt exist, exit..
            if(!fileExists) {
                System.out.println("File not found. Aborting read.");
                return patrons;
            }
            
            try {
                document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(patronsFile);
                document.getDocumentElement().normalize();
            } catch(Exception ex){
                System.out.println("Parse failure on Read. Aborting read.");
                ex.printStackTrace();
                return patrons;
            }

            //If the root node doesnt exist, abort. 
            NodeList rootNode = document.getElementsByTagName("patrons");
            if(rootNode == null || rootNode.getLength() < 1){
                System.out.println("Root node not found. Aborting read.");
                return patrons;
            }

            Element rootElement = (Element) rootNode.item(0);
            Element patronElement;
            NodeList patronNodes = rootElement.getElementsByTagName("patron");
            PatronDTO newPatron;
            
            for(int i = 0; i < patronNodes.getLength(); i++){
                //SEARCH FOR PATRON
                if(patronNodes.item(i) != null){
                    newPatron = new PatronDTO();
                    try {
                        //Get ID
                        patronElement = (Element) patronNodes.item(i);
                        newPatron.setPatronId(Integer.parseInt(patronElement.getAttribute("id")));
                        System.out.println("Reading Patron ID: " + newPatron.getPatronId() + " found. Updating record.");

                        //Get Basic Elements
                        newPatron.setPatronName(readBasicElement(patronElement, "patronName"));
                        newPatron.setFriendlyName(readBasicElement(patronElement, "friendlyName"));
                        newPatron.setDiscordName(readBasicElement(patronElement, "discordName"));
                        newPatron.setTierNum(Integer.parseInt(readBasicElement(patronElement, "tier")));
                        newPatron.setPledgeAmount(Double.parseDouble(readBasicElement(patronElement, "pledge")));
                        newPatron.setTotalAmount(Double.parseDouble(readBasicElement(patronElement, "totalAmount")));
                        newPatron.setPledgeDate(STUtil.formatStringToDate(readBasicElement(patronElement, "pledgeDate"), STStandard.XML_DATE_FORMAT));
                        newPatron.setDeclineDate(STUtil.formatStringToDate(readBasicElement(patronElement, "declineDate"), STStandard.XML_DATE_FORMAT));
                        newPatron.setSource(readBasicElement(patronElement, "source"));
                    } catch(Exception ex){
                        System.out.println("Setting Patron values failed. Adding incomplete patron. Please contact developer to resolve this.");
                        ex.printStackTrace();
                    }
                    
                    patrons.add(newPatron);
                } 
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return patrons;
    }

    public ArrayList<DonationDTO> readDonationsFile(){
        ArrayList<DonationDTO> donations = new ArrayList<>();
        File file = new File("donations.xml");

        return donations;
    }


    public static void writePatronsFile(ArrayList<PatronDTO> patrons){

        //Step 0: If file doesnt exist, create it. patrons.xml
        //Step 1: If file exists, search for IDs.
        //Step 2: If ID is found, edit info for the patron.
        //Step 3: If ID NOT found, add patron to the end of the patrons element.

        try {
            System.out.println("Writing Patrons File");
            File patronsFile = new File(patronsFilePath);
            boolean fileExists = patronsFile.exists();
            Document document;

            //If the file exists, we will edit it. If not, we create new file.
            if(fileExists){
                try {
                    document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(patronsFile);
                    document.getDocumentElement().normalize();
                } catch(Exception ex){
                    System.out.println("Parse failure. Creating new document.");
                    System.out.println("Stack Trace:");
                    ex.printStackTrace();
                    document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
                }
            } else{
                document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            }

            //If the root node exists, use it. If not, create it!
            Element rootElement;
            NodeList rootNode = document.getElementsByTagName("patrons");
            if(rootNode != null && rootNode.getLength() > 0){
                rootElement = (Element) rootNode.item(0);
            } else{
                rootElement = document.createElement("patrons");
                document.appendChild(rootElement);
            }

            //Convert patrons to a hashmap for easy searching
            HashMap<Integer, Element> existingPatronsMap = new HashMap<>();
            NodeList patronNodes = rootElement.getElementsByTagName("patron");
            Element element;
            for(int i = 0; i < patronNodes.getLength(); i++){
                element = (Element) patronNodes.item(i);
                existingPatronsMap.put(Integer.parseInt(element.getAttribute("id")), element);
            }

            Element patronElement;
            for(PatronDTO patron : patrons){
                //SEARCH FOR PATRON
                if(existingPatronsMap.get(patron.getPatronId()) != null){
                    System.out.println("Patron ID: " + patron.getPatronIdString() + " found. Updating record.");
                    patronElement = existingPatronsMap.get(patron.getPatronId());

                    updateBasicElement(document, patronElement, "patronName", patron.getPatronNameString());
                    updateBasicElement(document, patronElement, "tier", patron.getTierNumString());
                    updateBasicElement(document, patronElement, "pledge", patron.getPledgeAmountString());
                    updateBasicElement(document, patronElement, "totalAmount", patron.getTotalAmountString());
                    updateBasicElement(document, patronElement, "pledgeDate", patron.getPledgeDateStringXml());
                    updateBasicElement(document, patronElement, "declineDate", patron.getDeclineDateStringXml());
                    updateBasicElement(document, patronElement, "source", patron.getSourceString());
                } else {
                    //ADD NEW PATRON
                    System.out.println("Patron ID: " + patron.getPatronIdString() + " not found. Adding record.");
                    //main patron element + id attribute
                    patronElement = document.createElement("patron");
                    rootElement.appendChild(patronElement);

                    Attr idAttribute = document.createAttribute("id");
                    idAttribute.setValue(patron.getPatronIdString());
                    patronElement.setAttributeNode(idAttribute);

                    //Create basic elements
                    patronElement.appendChild(createBasicElement(document, "patronName", patron.getPatronNameString()));
                    patronElement.appendChild(createBasicElement(document, "friendlyName", patron.getFriendlyNameString()));
                    patronElement.appendChild(createBasicElement(document, "discordName", patron.getDiscordNameString()));
                    patronElement.appendChild(createBasicElement(document, "tier", patron.getTierNumString()));
                    patronElement.appendChild(createBasicElement(document, "pledge", patron.getPledgeAmountString()));
                    patronElement.appendChild(createBasicElement(document, "totalAmount", patron.getTotalAmountString()));
                    patronElement.appendChild(createBasicElement(document, "pledgeDate", patron.getPledgeDateStringXml()));
                    patronElement.appendChild(createBasicElement(document, "declineDate", patron.getDeclineDateStringXml()));
                    patronElement.appendChild(createBasicElement(document, "source", patron.getSourceString()));
                }
            }

            Transformer transformer = createTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(patronsFile);
            transformer.transform(source, result);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void writeDonationsFile(ArrayList<DonationDTO> donations){
        File file = new File("donations.xml");

    }

    //Create a basic element given the document, the element name, and the element value.
    private static Element createBasicElement(Document doc, String elementName, String elementValue){
        Element element;
        element = doc.createElement(elementName);
        element.appendChild(doc.createTextNode(elementValue));
        return element;
    }

    //Create a basic element given the document, the element name, and the element value.
    private static void updateBasicElement(Document doc, Element parentElement, String elementName, String elementValue) {
        NodeList nodes = parentElement.getElementsByTagName(elementName);
        Node node = nodes.item(0);

        //If the node doesnt exist (new node or it was deleted or something), create the node.
        if (node != null) {
            if (node.getFirstChild() != null) {
                Node child = node.getFirstChild();
                child.setNodeValue(elementValue);
            } else if (elementValue != null && !elementValue.equals("")) {
                node.appendChild(doc.createTextNode(elementValue));
            }
        } else{
            parentElement.appendChild(createBasicElement(doc, elementName, elementValue));
        }
    }

    //Read a basic element given a parent element and the element name.
    private static String readBasicElement(Element parentElement, String elementName) {
        NodeList nodes = parentElement.getElementsByTagName(elementName);
        Node node = nodes.item(0);

        if (node == null || node.getFirstChild() == null) {
            return "";
        } else {
            return node.getFirstChild().getNodeValue();
        }
    }
    
    private static Transformer createTransformer(){
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            //Indent output so it looks pretty
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            return transformer;
        } catch(Exception e){
            System.out.println("Error creating XML Transformer. Stack Trace:");
            e.printStackTrace();
            return null;
        }
    }
}
