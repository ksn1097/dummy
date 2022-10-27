package com.camunda.example.SICalculator.process;

import com.camunda.example.SICalculator.entity.Department;
import com.camunda.example.SICalculator.repository.DepartmentRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InterestCalculator implements JavaDelegate {

    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        System.out.println("InterestCalculator Implementation Started ");

        Integer dept_id = (Integer)delegateExecution.getVariable("departmentId");
        String name = (String)delegateExecution.getVariable("departmentName");
        Double income = (Double)delegateExecution.getVariable("income");
        Double years = (Double)delegateExecution.getVariable("years");
        Double rate = (Double)delegateExecution.getVariable("rate");
        Double totalInterest = calculateInterest(income, years, rate);
        Department deptRecord = Department
                .builder()
                .deptId(dept_id)
                .deptName(name)
                .deptIncome(income)
                .years(years)
                .rateOfInterest(rate)
                .simpleInterest(totalInterest)
                .build();

        departmentRepository.save(deptRecord);
        System.out.println("InterestCalculator Implementation Completed");

    }

    public Double calculateInterest(Double amount,Double years,Double rate){
        Double totalAmount= (amount*years*rate)/100;
        return totalAmount;
    }
}
