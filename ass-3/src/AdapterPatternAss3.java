class OldPrinter {
    public void printDocument(String document) {
        System.out.println("Printing: " + document);
    }
}

interface NewPrinter {
    void print(String document);
}

class OldPrinterAdapter implements NewPrinter {
    private OldPrinter oldPrinter;

    public OldPrinterAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    @Override
    public void print(String document) {
        oldPrinter.printDocument(document);
    }
}

public class AdapterPatternAss3 {

    public static void main(String[] args) {
        OldPrinter oldPrinter = new OldPrinter();
        NewPrinter newPrinter = new OldPrinterAdapter(oldPrinter);

        newPrinter.print("Document to be printed");
    }
}
