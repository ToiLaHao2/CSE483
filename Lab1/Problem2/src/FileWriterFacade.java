public class FileWriterFacade {
    private ConcreteFileWriters concreteFileWriters;

    public FileWriterFacade() {
        concreteFileWriters = new ConcreteFileWriters();
    }

    public void writeData(int option) {
        concreteFileWriters.writeData(option);
    }
}
