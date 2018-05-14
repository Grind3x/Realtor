import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class ApartmentsForSale {
    @XmlElement(name = "apartment")
    private List<Apartment> apartmentsForSale = new ArrayList<>();

    public ApartmentsForSale() {
    }

    public void addApartment(Apartment apartment) {
        if (apartment == null) {
            throw new IllegalArgumentException("apartment is null!");
        }
        apartmentsForSale.add(apartment);
    }

    public boolean removeApartment(String address) {
        if (address == null) {
            throw new IllegalArgumentException("address is null!");
        }

        for (int i = 0; i < apartmentsForSale.size(); i++) {
            if (apartmentsForSale.get(i).getAddress().equals(address)) {
                apartmentsForSale.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ApartmentsForSale{" +
                "apartments=" + apartmentsForSale +
                '}';
    }
}
