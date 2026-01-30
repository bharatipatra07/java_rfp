import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {

    public int loadStateCensusData(String csvFilePath) throws Exception {

        Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));

        CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader)
                .withType(CSVStateCensus.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        Iterator<CSVStateCensus> censusIterator = csvToBean.iterator();

        int count = 0;
        while (censusIterator.hasNext()) {
            CSVStateCensus censusData = censusIterator.next();
            count++;
        }
        return count;
    }
}
