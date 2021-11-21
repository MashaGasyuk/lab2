package lab_2.desirialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XMLDeserialize<T> implements IDeserialize<T>{
    final Class<T> clazz;

    public XMLDeserialize(Class<T> type){
        clazz = type;
    }

    @Override
    public T toObject(String str) throws Exception {
        ObjectMapper mapper = new XmlMapper();
        return mapper.readValue(str,clazz);
    }
}
