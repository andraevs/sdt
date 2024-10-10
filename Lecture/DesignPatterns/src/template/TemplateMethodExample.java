package template;

abstract class ReportGenerator {
    public final void generateReport() {
        openDocument();
        gatherData();
        formatContent();
        closeDocument();
    }

    private void openDocument() {
        System.out.println("Opening document...");
    }

    private void closeDocument() {
        System.out.println("Closing document...");
    }

    abstract void gatherData();
    abstract void formatContent();
}

class FinanceReportGenerator extends ReportGenerator {
    @Override
    void gatherData() {
        System.out.println("Gathering financial data...");
    }

    @Override
    void formatContent() {
        System.out.println("Formatting content as financial tables and charts.");
    }
}

class HRReportGenerator extends ReportGenerator {
    @Override
    void gatherData() {
        System.out.println("Gathering HR data...");
    }

    @Override
    void formatContent() {
        System.out.println("Formatting content as employee performance summaries.");
    }
}

public class TemplateMethodExample {
    public static void main(String[] args) {
        ReportGenerator financeReport = new FinanceReportGenerator();
        financeReport.generateReport();

        System.out.println();

        ReportGenerator hrReport = new HRReportGenerator();
        hrReport.generateReport();
    }
}
