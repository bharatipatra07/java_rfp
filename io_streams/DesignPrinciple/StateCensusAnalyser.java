package DesignPrinciple;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import java.io.IOException;

public class StateCensusAnalyser {

	public int loadStateCensusData(String csvFilePath)
	        throws CensusAnalyserException {

	    try {
	        Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));

	        CsvToBean<CSVStateCensus> csvToBean =
	                new CsvToBeanBuilder<CSVStateCensus>(reader)
	                        .withType(CSVStateCensus.class)
	                        .withIgnoreLeadingWhiteSpace(true)
	                        .build();

	        Iterator<CSVStateCensus> iterator = csvToBean.iterator();

	        int count = 0;
	        while (iterator.hasNext()) {
	            CSVStateCensus data = iterator.next();

	            // Delimiter issue → fields not populated
	            if (data.state == null) {
	                throw new CensusAnalyserException(
	                        "Invalid CSV delimiter",
	                        CensusAnalyserException.ExceptionType.INVALID_DELIMITER
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
