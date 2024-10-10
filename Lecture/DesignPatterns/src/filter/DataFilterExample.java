package filter;

// common interface for DataSource, Filters, and DataSink
interface DataProcessor {
    String process(String data);
}

class SimpleDataSource implements DataProcessor {
    private String data;

    public SimpleDataSource(String data) {
        this.data = data;
    }

    @Override
    public String process(String data) {
        return this.data;
    }
}


// Removes vowels from the input
class VowelRemoverFilter implements DataProcessor {
    @Override
    public String process(String data) {
        return data.replaceAll("[AEIOUaeiou]", "");
    }
}

// Converts all characters to uppercase
class UpperCaseFilter implements DataProcessor {
    @Override
    public String process(String data) {
        return data.toUpperCase();
    }
}

// Trims leading and trailing spaces
class TrimFilter implements DataProcessor {
    @Override
    public String process(String data) {
        return data.trim();
    }
}

// Step 4: DataSink that processes the filtered data
class DataSink implements DataProcessor {
    @Override
    public String process(String data) {
        System.out.println("Final Processed Data: " + data);
        return data;
    }
}

public class DataFilterExample {
    public static void main(String[] args) {
        String inputData = "   Hello World, Welcome to Data Filters!   ";

        DataProcessor dataSource = new SimpleDataSource(inputData);

        DataProcessor vowelRemoverFilter = new VowelRemoverFilter();
        DataProcessor upperCaseFilter = new UpperCaseFilter();
        DataProcessor trimFilter = new TrimFilter();

        DataProcessor dataSink = new DataSink();

        System.out.println("Original Data: " + dataSource.process(null));

        String processedData = dataSource.process(null);    // Original data
        processedData = vowelRemoverFilter.process(processedData);  // Remove vowels
        processedData = upperCaseFilter.process(processedData);     // Convert to uppercase
        processedData = trimFilter.process(processedData);          // Trim spaces

        dataSink.process(processedData);
    }
}
