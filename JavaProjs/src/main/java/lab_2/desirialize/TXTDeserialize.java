package lab_2.desirialize;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Base64;

public class TXTDeserialize<T> implements IDeserialize<T>{
    final Class<T> clazz;
    public TXTDeserialize(Class<T> type){
        clazz = type;
    }


    @Override
    public T toObject(String str) throws Exception {
        byte[] data = Base64.getDecoder().decode(str);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        T res = (T) ois.readObject();
        ois.close();
        return res;
    }
}
