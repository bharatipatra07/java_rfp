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

        // FILE TYPE CHECK
        if (!csvFilePath.endsWith(".csv")) {
            throw new CensusAnalyserException(
                    "Invalid file type",
                    CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE
            );
        }

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
                iterator.next();
                count++;
            }
            return count;

        } catch (IOException e) {
            throw new CensusAnalyserException(
                    "File path problem",
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM
            );
        }
    }
}
