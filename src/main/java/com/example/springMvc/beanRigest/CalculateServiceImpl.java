package com.example.springMvc.beanRigest;

public class CalculateServiceImpl implements CalculateService{

    private String serviceDesc = "desc from class";
    @Override
    public int add(int a, int b) {
        return 0;
    }

    @Override
    public String getServiceDesc() {
        return serviceDesc;
    }

    @Override
    public void setServiceDesc(String serviceDesc) {
       this.serviceDesc=serviceDesc;
    }
}
