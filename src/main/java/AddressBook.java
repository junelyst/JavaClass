import java.util.*;

public final class AddressBook {
    private HashMap<String, Address> book = new HashMap<>();

    public void add(String person, Address address) {
        if (address.street.matches("[^\\p{Punct}]+") && (address.house.matches("\\d+"))
                && (address.flat.matches("\\d+"))) {
            if (book.containsKey(person))
                throw new IllegalArgumentException("This person is already in address book");
            else book.put(person, address);
        }
    }

    public int size() {
        return book.size();
    }

    public void remove(String person) {
        if (book.containsKey(person))
        book.remove(person);
        else throw new IllegalArgumentException("This person is not in address book");
    }

    public void changeAddress(String person, Address newAddress) {
        if (book.containsKey(person))
        book.replace(person, newAddress);
        else throw new IllegalArgumentException("This person is not in address book");
    }

    public Address getAddress(String person) {
        if (book.containsKey(person))
            return book.get(person);
        else throw new IllegalArgumentException("This person is not in address book");
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