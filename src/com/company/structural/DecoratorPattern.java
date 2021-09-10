package com.company.structural;

// Adapter pattern provides a different interface to the wrapped object.
// Decorator provides an enhanced interface to the wrapped object.
// To be used when the client could required different combination
// or behaviour from the object and cannot change the behaviour of the object.
// Composition over inheritance.
// The decorator stack could get ugly.
// This is different from Chain of responsibility. here chain can't be stopped.
// CoR can perform action irrespective of each other. Decorator cannot.

public class DecoratorPattern {

    public static void main(String[] args) {
        DataStream dataStream = new FileDataStream();
        dataStream = new EncryptedDataStream(dataStream);
        dataStream = new CompressedDataStream(dataStream);

        dataStream.readData();
    }

}

interface DataStream{
    void readData();
}

class FileDataStream implements DataStream{
    @Override
    public void readData() {
        System.out.println("Reading data from the file");
    }
}

class DecoratorDataStream implements DataStream{
    protected DataStream dataStream;

    public DecoratorDataStream(DataStream dataStream) {
        this.dataStream = dataStream;
    }

    @Override
    public void readData() {
        dataStream.readData();
    }
}

class EncryptedDataStream extends DecoratorDataStream{

    public EncryptedDataStream(DataStream dataStream) {
        super(dataStream);
    }

    @Override
    public void readData() {
        System.out.println("Decrypting Data Stream");
        dataStream.readData();
    }
}

class CompressedDataStream extends DecoratorDataStream{
    public CompressedDataStream(DataStream dataStream) {
        super(dataStream);
    }

    @Override
    public void readData() {
        System.out.println("decompressing data stream");
        dataStream.readData();
    }
}

