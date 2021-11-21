package lab_2.serialize;

import java.io.IOException;

public interface ISerialize<T> {
    String fromObject(T object) throws IOException;
}
