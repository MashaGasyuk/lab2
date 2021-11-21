package lab_2.desirialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class JSONDeserialize<T> implements IDeserialize<T>{
    final Class<T> clazz;
    public JSONDeserialize(Class<T> type){
        clazz = type;
    }
    @Override
    public T toObject(String str) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(str,clazz);
    }
}
