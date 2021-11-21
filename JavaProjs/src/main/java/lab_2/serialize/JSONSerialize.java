package lab_2.serialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.IOException;

public class JSONSerialize<T> implements ISerialize<T> {
    @Override
    public String fromObject(T object) throws IOException {
        ObjectMapper mapper = new JsonMapper();
        return mapper.writeValueAsString(object);
    }

}
