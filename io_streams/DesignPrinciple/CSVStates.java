package DesignPrinciple;

import com.opencsv.bean.CsvBindByName;

public class CSVStates {

    @CsvBindByName(column = "StateName")
    public String stateName;

    @CsvBindByName(column = "StateCode")
    public String stateCode;
}
