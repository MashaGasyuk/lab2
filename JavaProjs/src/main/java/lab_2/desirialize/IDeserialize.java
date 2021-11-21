package lab_2.desirialize;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IDeserialize<T> {
    T toObject(String str) throws Exception;
}
