package lab_2.serialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

public class XMLSerialize<T> implements ISerialize<T> {
    @Override
    public String fromObject(T object) throws IOException {
        ObjectMapper mapper = new XmlMapper();
        return mapper.writeValueAsString(object);
    }
}
