public class ConcreteFileWriters {
    private CompressionCodec compressionCodec;
    private EncryptionCodec encryptionCodec;
    private FileWriterFactory fileWriterFactory;

    public ConcreteFileWriters() {
        compressionCodec = new CompressionCodec();
        encryptionCodec = new EncryptionCodec();
        fileWriterFactory = new FileWriterFactory();
    }

    public void writeData(int option) {
        switch (option) {
            case 1:
                compressionGZip();
                break;
            case 2:
                compressionBZip2();
                break;
            case 3:
                encryptionAES();
                break;
            case 4:
                encryptionDES();
                break;
            case 5:
                fileWriterCSV();
                break;
            case 6:
                fileWriterJSON();
                break;
            case 7:
                fileWriterXML();
                break;
            default:
                break;
        }
    }

    private void compressionGZip() {
        compressionCodec.GZip();
    }

    private void compressionBZip2() {
        compressionCodec.BZip2();
    }

    private void encryptionAES() {
        encryptionCodec.AESEncrypt();
    }

    private void encryptionDES() {
        encryptionCodec.DESEncrypt();
    }

    private void fileWriterCSV() {
        fileWriterFactory.CSV();
    }

    private void fileWriterJSON() {
        fileWriterFactory.JSON();
    }

    private void fileWriterXML() {
        fileWriterFactory.XML();
    }
}
