import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Apartments {
    @XmlElement(name = "apartment")
    private List<Apartment> apartments = new ArrayList<>();

    public Apartments() {
    }

    public void addApartment(Apartment apartment) {
        if (apartment == null) {
            throw new IllegalArgumentException();
        }
        apartments.add(apartment);
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public Apartment getApartmentByAddress(String address) {
        if (address == null) {
            throw new IllegalArgumentException("address is null");
        }

        for (int i = 0; i < apartments.size(); i++) {
            if (apartments.get(i).getAddress().equals(address)) {
                return apartments.get(i);
            }
        }
        return null;
    }

    public List<Apartment> getApartmentsByNumberOfRooms(int numberOfRooms) {
        if (numberOfRooms == 0) {
            throw new IllegalArgumentException("Number of rooms can't be 0!");
        }
        List<Apartment> list = new ArrayList<>();
        for (Apartment apartment : apartments) {
            if (apartment.getNumberOfRooms() == numberOfRooms) {
                list.add(apartment);
            }
        }
        return list;
    }

    public List<Apartment> getApartmentsByCostRange(double low, double high) {
        if (low > high) {
            throw new IllegalArgumentException("The upper parameter can not be less than the lower!");
        }
        List<Apartment> list = new ArrayList<>();
        for (Apartment apartment : apartments) {
            if ((apartment.getCost() >= low) && (apartment.getCost() <= high)) {
                list.add(apartment);
            }
        }
        return list;
    }

    public boolean changeApartmentCost(String address, double cost) {
        if (address == null) {
            throw new IllegalArgumentException("adress is null");
        }

        Apartment apartment;
        if ((apartment = getApartmentByAddress(address)) != null) {
            apartment.setCost(cost);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Apartments{" +
                "apartments=" + apartments +
                '}';
    }
}
