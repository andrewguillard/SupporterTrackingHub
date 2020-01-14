package com.amg.supporttracker.gui.util;

import com.amg.supporttracker.gui.util.dto.DonationDTO;
import com.amg.supporttracker.gui.util.dto.PatronDTO;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class XMLParser {

    public ArrayList<PatronDTO> readPatronsFile(){
        ArrayList<PatronDTO> patrons = new ArrayList<>();
        File file = new File("patrons.xml");

        return patrons;
    }

    public ArrayList<DonationDTO> readDonationsFile(){
        ArrayList<DonationDTO> donations = new ArrayList<>();
        File file = new File("donations.xml");

        return donations;
    }

    //TODO: Search file for existing IDs and edit instead of rewriting so we don't remove friendly names
    public static void writePatronsFile(ArrayList<PatronDTO> patrons){
        String patronId, patronName, friendlyName, discordName, tier, pledge, totalAmount, pledgeDate, declineDate;

        try {
            System.out.println("Writing Patrons File");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.newDocument();

            //root element
            Element rootElement = document.createElement("patrons");
            document.appendChild(rootElement);

            //TODO: Add string getters to PatronDTO
            for(PatronDTO patron : patrons){
                patronId =      String.valueOf(patron.getPatronId());
                patronName =    patron.getPatronName() != null ? patron.getPatronName() : "";
                friendlyName =  patron.getFriendlyName() != null ? patron.getFriendlyName() : "";
                discordName =   patron.getDiscordName() != null ? patron.getDiscordName() : "";
                tier =          String.valueOf(patron.getTierNum());
                pledge =        String.valueOf(patron.getPledgeAmount());
                totalAmount =   String.valueOf(patron.getTotalAmount());
                pledgeDate =    patron.getPledgeDate() != null ? STUtil.formatDate(patron.getPledgeDate(), "mm/dd/yyyy") : "";
                declineDate =   patron.getDeclineDate() != null ? STUtil.formatDate(patron.getDeclineDate(), "mm/dd/yyyy") : "";

                //main patron element + id attribute
                Element patronElement = document.createElement("patron");
                rootElement.appendChild(patronElement);

                Attr idAttribute = document.createAttribute("id");
                idAttribute.setValue(patronId);
                patronElement.setAttributeNode(idAttribute);

                //Patron Name Element
                Element patronNameElement = document.createElement("patronName");
                patronNameElement.appendChild(document.createTextNode(patronName));
                patronElement.appendChild(patronNameElement);

                //Friendly Name Element
                Element friendlyNameElement = document.createElement("friendlyName");
                friendlyNameElement.appendChild(document.createTextNode(friendlyName));
                patronElement.appendChild(friendlyNameElement);

                //Discord Name Element
                Element discordNameElement = document.createElement("discordName");
                discordNameElement.appendChild(document.createTextNode(discordName));
                patronElement.appendChild(discordNameElement);

                //Tier Element
                Element tierElement = document.createElement("tier");
                tierElement.appendChild(document.createTextNode(tier));
                patronElement.appendChild(tierElement);

                //Pledge Element
                Element pledgeElement = document.createElement("pledge");
                pledgeElement.appendChild(document.createTextNode(pledge));
                patronElement.appendChild(pledgeElement);

                //Total Pledge Element
                Element totalAmountElement = document.createElement("totalAmount");
                totalAmountElement.appendChild(document.createTextNode(totalAmount));
                patronElement.appendChild(totalAmountElement);

                //Pledge Date Element
                Element pledgeDateElement = document.createElement("pledgeDate");
                pledgeDateElement.appendChild(document.createTextNode(pledgeDate));
                patronElement.appendChild(pledgeDateElement);

                //Decline Date Element
                Element declineDateElement = document.createElement("declineDate");
                declineDateElement.appendChild(document.createTextNode(declineDate));
                patronElement.appendChild(declineDateElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("patrons.xml"));
            transformer.transform(source, result);

        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void writeDonationsFile(ArrayList<DonationDTO> donations){
        File file = new File("donations.xml");

    }


}
