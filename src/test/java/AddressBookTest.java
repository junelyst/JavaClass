import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class AddressBookTest {

    private AddressBook.Address address1 = new AddressBook.Address("street1", "14", "25");
    private AddressBook.Address address2 = new AddressBook.Address("street2", "11", "18");
    private AddressBook.Address address3 = new AddressBook.Address("street2", "11", "44");
    private AddressBook.Address address4 = new AddressBook.Address("street3", "14", "44");

    @Test
    public void add() {
        AddressBook book = new AddressBook();
        book.add("person1", address1);
        assertSame(1, book.size());
    }

    @Test
    public void size() {
        AddressBook book = new AddressBook();
        book.add("person1", address1);
        book.add("person2", address2);
        assertSame(2, book.size());
    }

    @Test
    public void remove() {
        AddressBook book = new AddressBook();
        book.add("person1", address1);

        book.remove("person2");
        assertSame(1, book.size());

        book.remove("person1");
        assertSame(0, book.size());
    }

    @Test
    public void changeAddress() {
        AddressBook book = new AddressBook();
        book.add("person1", address1);

        book.changeAddress("person1", address2);
        ArrayList<String> newAddress1 = book.getAddress("person1");
        assertSame("street2", newAddress1.get(0));
        assertSame("11", newAddress1.get(1));
        assertSame("18", newAddress1.get(2));
        assertSame(3, newAddress1.size());

        book.changeAddress("person12", address2);
        ArrayList<String> newAddress2 = book.getAddress("person12");
        assertSame(0, newAddress2.size());
    }

    @Test
    public void getAddress() {
        AddressBook book = new AddressBook();

        book.add("person1", address1);
        book.add("person2", address2);
        ArrayList<String> list1 = book.getAddress("person1");
        assertSame("street1", list1.get(0));
        assertSame("14", list1.get(1));
        assertSame("25", list1.get(2));
        assertSame(3, list1.size());

        ArrayList<String> list = book.getAddress("person3");
        assertSame(0, list.size());
    }

    @Test
    public void searchByStreet() {
        AddressBook book = new AddressBook();
        book.add("person1", address1);
        book.add("person2", address2);
        book.add("person3", address3);
        book.add("person4", address4);

        ArrayList<String> res1 = book.searchByStreet("street2");
        assertSame(2, res1.size());

        ArrayList<String> res2 = book.searchByStreet("street12");
        assertSame(0, res2.size());
    }

    @Test
    public void searchByHouse() {
        AddressBook book = new AddressBook();
        book.add("person1", address1);
        book.add("person2", address2);
        book.add("person3", address3);
        book.add("person4", address4);

        ArrayList<String> res1 = book.searchByHouse("street2", "11");
        assertSame(2, res1.size());

        ArrayList<String> res2 = book.searchByHouse("street1", "14");
        assertSame(1, res2.size());
    }
}