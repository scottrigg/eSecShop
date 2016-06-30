package order;

import support.Address;

import java.util.ArrayList;

/**
 * Created by mac on 16/6/26.
 */
public class DeliverOrder extends Order {
    private Address address;

    public DeliverOrder(String ID,Address address) {
        super(ID);
        this.address = address;
        super.status = new ArrayList<String>();
        super.status.add("Wait for confirm,system,"+super.currentDate());
    }

    @Override
    public String toString() {
        return "Deliver" + super.toString() + address.toString();
    }
}
