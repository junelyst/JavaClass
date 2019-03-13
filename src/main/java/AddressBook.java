import java.util.*;

public final class AddressBook {
    private HashMap<String, Address> book = new HashMap<>();
    static class Address {
        String street;
        String house;
        String flat;

        Address(String street, String house, String flat) {
            this.street = street;
            this.house = house;
            this.flat = flat;
        }
    }

    public void add(String person, Address address) {
        if (address.street.matches("[^\\p{Punct}]+") && (address.house.matches("\\d+"))
                && (address.flat.matches("\\d+")))
        book.put(person, address);
    }

    public int size() {
        return book.size();
    }

    public void remove(String person) {
        book.remove(person);
    }

    public void changeAddress(String person, Address newAddress) {
        book.replace(person, newAddress);
    }

    public ArrayList<String> getAddress(String person) {
        ArrayList<String> list = new ArrayList<>();
        try {
            Address address = book.get(person);
            list.add(address.street);
            list.add(address.house);
            list.add(address.flat);
            return list;
        }
        catch (NullPointerException e) {
            return list;
        }
    }

    public ArrayList<String> searchByStreet(String street) {
        ArrayList<String> listByStreet = new ArrayList<>();
        for (Map.Entry<String, Address> pair : book.entrySet()) {
            Address address = pair.getValue();
            if (address.street.equals(street))
                listByStreet.add(pair.getKey());
        }
        return listByStreet;
    }

    public ArrayList<String> searchByHouse(String street, String house) {
        ArrayList<String> listByHouse = new ArrayList<>();
        for (Map.Entry<String, Address> pair : book.entrySet()) {
            Address address = pair.getValue();
            if (address.street.equals(street) && address.house.equals(house))
                listByHouse.add(pair.getKey());
        }
        return listByHouse;
    }
}