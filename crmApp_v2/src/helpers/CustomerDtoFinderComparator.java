package helpers;

import dto.CustomerDto;

import java.time.LocalDateTime;
import java.util.Comparator;

public class CustomerDtoFinderComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        CustomerDto c1 = (CustomerDto) o1;
        CustomerDto c2 = (CustomerDto) o2;

        Integer id1 = c1.getId();
        Integer id2 = c2.getId();
        if ((notNullObject(id1,id2)) && (id1==id2)) {
            return 0;
        }

        String firstname1 = c1.getFirstname();
        String firstname2 = c2.getFirstname();
        if ((notNullObject(firstname1,firstname2)) && (firstname1.equals(firstname2))) {
            return 0;
        }

        String lastname1 = c1.getLastname();
        String lastname2 = c2.getLastname();
        if ((notNullObject(lastname1,lastname2)) && (lastname1.equals(lastname2))) {
            return 0;
        }

        LocalDateTime created1 = c1.getCreated();
        LocalDateTime created2 = c2.getCreated();
        if ((notNullObject(created1,created2)) && (created1==created2)) {
            return 0;
        }

        LocalDateTime modified1 = c1.getModified();
        LocalDateTime modified2 = c2.getModified();
        if ((notNullObject(modified1,modified2)) && (modified1==modified2)) {
            return 0;
        }
        return 1;
    }

    private boolean notNullObject(Object o1, Object o2) {
        if (o1!=null && o2!=null) {
            return true;
        }
        return false;
    }
}
