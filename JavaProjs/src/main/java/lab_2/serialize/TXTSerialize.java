package lab_2.serialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.sql.Blob;
import java.util.Base64;
import java.util.stream.Stream;

public class TXTSerialize<T> implements ISerialize<T> {
    @Override
    public String fromObject(T object) throws IOException {
       ByteArrayOutputStream baos = new ByteArrayOutputStream();
       ObjectOutputStream oos = new ObjectOutputStream(baos);

       oos.writeObject(object);
       oos.close();
       return Base64.getEncoder().encodeToString(baos.toByteArray());
    }
}
