package chap05.Q05;

import java.util.List;
import java.util.ArrayList;

public class ComplexReportGenerator extends AbstractReportGenerator {
    private int numOfCustomers = 0;
    private int sum = 0;
    protected boolean customerReportCondition(Customer customer) {
        return customer.getPoint() >= 100;
    }

    @Override
    protected String getReportHeader(List<Customer> customers) {
        for (Customer customer: customers) {
            if (customerReportCondition(customer)) numOfCustomers++;
        }
        return String.format("고객의 수: %d 명 입니다\n", numOfCustomers);
    }

    @Override
    protected String getReportForCustomer(Customer customer) {
        if (!customerReportCondition(customer)) return null;
        sum += customer.getPoint();
        return String.format("%s: %d\n", customer.getName(), customer.getPoint());
    }

    @Override
    protected String getReportFooter(List<Customer> customers) {
        return String.format("점수 합계: %d", sum);
    }
}
