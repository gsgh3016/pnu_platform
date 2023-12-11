package chap05.Q05;

import java.util.List;
import java.util.ArrayList;

public abstract class AbstractReportGenerator {
    public final String generate(List<Customer> customers) {
        List<Customer> selectedCustomers = select(customers);
        String report = getReportHeader(selectedCustomers);
        for (final Customer customer : selectedCustomers) report += getReportForCustomer(customer);
        report += getReportFooter(selectedCustomers);
        return report;
    }

    protected List<Customer> select(List<Customer> customers) {
        List<Customer> selected = new ArrayList<Customer>();
        for (final Customer customer : customers)
            if (customerReportCondition(customer)) selected.add(customer);
        return selected;
    }

    protected abstract boolean customerReportCondition(Customer customer);
    protected abstract String getReportHeader(List<Customer> customers);
    protected abstract String getReportForCustomer(Customer customer);
    protected abstract String getReportFooter(List<Customer> customers);
}
