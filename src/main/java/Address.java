public class Address {
    String street;
    String house;
    String flat;

    Address(String street, String house, String flat) {
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Address address = (Address) obj;
        return address.street.equals(street) && address.house.equals(house) && address.flat.equals(flat);
    }
}
