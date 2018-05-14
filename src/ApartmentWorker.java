import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ApartmentWorker {

    public static void saveApartmentsToXML(Apartments apartments, File file) {
        if (apartments == null || file == null) {
            throw new IllegalArgumentException("arguments are null!");
        }
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Apartments.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(apartments, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Apartments getApartmentsFromXML(File file) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Apartments.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Apartments) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void saveApartmentsForSaleToXML(ApartmentsForSale apartmentsForSale, File file) {
        if (apartmentsForSale == null || file == null) {
            throw new IllegalArgumentException("arguments are null!");
        }
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ApartmentsForSale.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(apartmentsForSale, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static ApartmentsForSale getApartmentForSaleFromXML(File file) {
        if (file == null) {
            throw new IllegalArgumentException("file is null");
        }
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(ApartmentsForSale.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (ApartmentsForSale) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}
