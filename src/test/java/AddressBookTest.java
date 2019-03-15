import org.junit.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.*;

import static org.junit.Assert.*;

public class AddressBookTest {

    private Address address1 = new Address("street1", "14", "25");
    private Address address2 = new Address("street2", "11", "18");
    private Address address3 = new Address("street2", "11", "44");
    private Address address4 = new Address("street3", "14", "44");

    @Test
    public void add() {
        AddressBook book = new AddressBook();
        book.add("person1", address1);
        assertEquals(1, book.size());

        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() {
                book.add("person1", address2);
            }
        });
    }

    @Test
    public void size() {
        AddressBook book = new AddressBook();
        book.add("person1", address1);
        book.add("person2", address2);
        assertEquals(2, book.size());
    }

    @Test
    public void remove() {
        AddressBook book = new AddressBook();
        book.add("person1", address1);

        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() {
                book.remove("person2");
            }
        });

        book.remove("person1");
        assertEquals(0, book.size());
    }

    @Test
    public void changeAddress() {
        AddressBook book = new AddressBook();
        book.add("person1", address1);

        book.changeAddress("person1", address2);
        Address newAddress1 = book.getAddress("person1");
        assertEquals(address2, newAddress1);

        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() {
                book.changeAddress("person12", address2);
            }
        });
    }

    @Test
    public void getAddress() {
        AddressBook book = new AddressBook();

        book.add("person1", address1);
        book.add("person2", address2);
        Address getAddress2 = book.getAddress("person2");
        assertEquals(address2, getAddress2);

        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() {
                book.getAddress("person12");
            }
        });
    }

    @Test
    public void searchByStreet() {
        AddressBook book = new AddressBook();
        book.add("person1", address1);
        book.add("person2", address2);
        book.add("person3", address3);
        book.add("person4", address4);

        ArrayList<String> res1 = book.searchByStreet("street2");
        Collections.sort(res1);
        assertEquals(Arrays.asList("person2", "person3"), res1);

        ArrayList<String> res2 = book.searchByStreet("street12");
        assertEquals(0, res2.size());
    }

    @Test
    public void searchByHouse() {
        AddressBook book = new AddressBook();
        book.add("person1", address1);
        book.add("person2", address2);
        book.add("person3", address3);
        book.add("person4", address4);

        ArrayList<String> res1 = book.searchByHouse("street2", "11");
        Collections.sort(res1);
        assertEquals(Arrays.asList("person2", "person3"), res1);

        ArrayList<String> res2 = book.searchByHouse("street1", "14");
        assertEquals(Collections.singletonList("person1"), res2);

        ArrayList<String> res3 = book.searchByHouse("street1", "50");
        assertEquals(0, res3.size());
    }
}