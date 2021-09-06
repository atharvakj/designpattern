package com.company.structural;

// strutural pattern come in to picture during compile time.
// to be used when you have an existing code which wants to use a
// third party software but the interface does not match.
// related pattern are proxy, delegate and decorater
// also facade

// there are two types of Adapter:
// 1. Class Adapter: when you extend the client class and the service class and implement the methods
// this is less common and has more headache.
// 2. Object Adapter: When you only wrap around the third party class and translate the
// existing interface to the new method calls.
// Below is the implementation for Object Adapter Pattern.
public class AdapterPattern {
    public static void main(String[] args) {
        new Client(new AdapterDataReaderService(new ThirdPartyDataReader())).consumeData();
    }
}

class Client {
    DataReaderService serivce;

    public Client(DataReaderService serivce) {
        this.serivce = serivce;
    }

    void consumeData(){
        serivce.readData();
    }
}

interface  DataReaderService {
    void readData();
}

class AdapterDataReaderService implements DataReaderService{

    ThirdPartyDataReader reader;

    public AdapterDataReaderService(ThirdPartyDataReader reader) {
        this.reader = reader;
    }

    @Override
    public void readData() {
        reader.readFancyData();
    }
}

class ThirdPartyDataReader {
    void readFancyData(){
        System.out.println("Reading some really fancy data");
    }
}