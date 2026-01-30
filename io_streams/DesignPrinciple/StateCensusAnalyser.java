package DesignPrinciple;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import java.io.IOException;

public class StateCensusAnalyser {
	public int loadStateCodeData(String csvFilePath)
	        throws CensusAnalyserException {

	    try {
	        Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));

	        CsvToBean<CSVStates> csvToBean =
	                new CsvToBeanBuilder<CSVStates>(reader)
	                        .withType(CSVStates.class)
	                        .withIgnoreLeadingWhiteSpace(true)
	                        .build();

	        Iterator<CSVStates> iterator = csvToBean.iterator();

	        int count = 0;
	        while (iterator.hasNext()) {
	            CSVStates data = iterator.next();

	            if (data.stateName == null || data.stateCode == null) {
	                throw new CensusAnalyserException(
	                        "Invalid State Code CSV",
	                        CensusAnalyserException.ExceptionType.INVALID_FILE_FORMAT
	                );
	            }
	            count++;
	        }
	        return count;

	    } catch (IOException e) {
	        throw new CensusAnalyserException(
	                "File problem",
	                CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM
	        );
	    }
	}
  
  }
