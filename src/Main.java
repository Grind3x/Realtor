import java.io.File;

public class Main {
    public static void main(String[] args) {

        Apartments apartments = ApartmentWorker.getApartmentsFromXML(new File("Apartments.xml"));
        ApartmentsForSale apartmentsForSale = ApartmentWorker.getApartmentForSaleFromXML(
                new File("AppartmentsForSale.xml"));

        apartmentsForSale.addApartment(apartments.getApartmentByAddress("Kyiv, Bulvar Perova, 48/124"));
        System.out.println(apartmentsForSale);

        apartmentsForSale.removeApartment("Kyiv, Bulvar Perova, 48/127");
        System.out.println(apartmentsForSale);

        apartments.changeApartmentCost("Kyiv, Bulvar Perova, 48/124", 100500);
        System.out.println(apartments);

        System.out.println(apartments.getApartmentsByNumberOfRooms(3));
        System.out.println(apartments.getApartmentsByCostRange(30000, 40000));

        ApartmentWorker.saveApartmentsToXML(apartments,new File("Apartments.xml"));
        ApartmentWorker.saveApartmentsForSaleToXML(apartmentsForSale, new File("AppartmentsForSale.xml"));
    }
}
