/***

	the code below is a auto-modified source code file from fastjson library by alibaba.com,
	https://github.com/alibaba/fastjson.git

*/
/*
 * Copyright 1999-2018 Alibaba Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author wenshao[szujobs@hotmail.com]
 */
public class PrimitiveArraySerializer implements ObjectSerializer {

    public static PrimitiveArraySerializer instance = new PrimitiveArraySerializer();

    public final void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.out;
        
        if (object == null) {
            out.writeNull(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        
        if (object instanceof int[]) {
            serializeIntArray(object, out);
            return;
        }
        
        if (object instanceof short[]) {
            serializeShortArray(object, out);
            return;
        }
        
        if (object instanceof long[]) {
            serializeLongArray(object, out);
            return;
        }
        
        if (object instanceof boolean[]) {
            serializeBooleanArray(object, out);
            return;
        }
        
        if (object instanceof float[]) {
            writeFloatArray(object, out);
            return;
        }
        
        if (object instanceof double[]) {
            writeDoubleArray(object, out);
            return;
        }
        
        if (object instanceof byte[]) {
            byte[] array = (byte[]) object;
            out.writeByteArray(array);
            return;
        }
        
        char[] chars = (char[]) object;
        out.writeString(chars);
    }

	private void writeDoubleArray(Object object, SerializeWriter out) {
		double[] array = (double[]) object;
		out.write('[');
		for (int i = 0; i < array.length; ++i) {
		    writeComma(out, i);
            
            double item = array[i];
            if (Double.isNaN(item)) {
                out.writeNull();
            } else {
                out.append(Double.toString(item));
            }
		}
		out.write(']');
	}

	private void writeFloatArray(Object object, SerializeWriter out) {
		float[] array = (float[]) object;
		out.write('[');
		for (int i = 0; i < array.length; ++i) {
		    writeComma(out, i);
            
            float item = array[i];
            if (Float.isNaN(item)) {
                out.writeNull();
            } else {
                out.append(Float.toString(item));
            }
		}
		out.write(']');
	}

	private void serializeBooleanArray(Object object, SerializeWriter out) {
		boolean[] array = (boolean[]) object;
		out.write('[');
		for (int i = 0; i < array.length; ++i) {
		    writeComma(out, i);
		    out.write(array[i]);
		}
		out.write(']');
	}

	private void serializeLongArray(Object object, SerializeWriter out) {
		long[] array = (long[]) object;

		out.write('[');
		for (int i = 0; i < array.length; ++i) {
		    writeComma(out, i);
		    out.writeLong(array[i]);
		}
		out.write(']');
	}

	private void serializeShortArray(Object object, SerializeWriter out) {
		short[] array = (short[]) object;
		out.write('[');
		for (int i = 0; i < array.length; ++i) {
		    writeComma(out, i);
		    out.writeInt(array[i]);
		}
		out.write(']');
	}

	private void serializeIntArray(Object object, SerializeWriter out) {
		int[] array = (int[]) object;
		out.write('[');
		for (int i = 0; i < array.length; ++i) {
		    writeComma(out, i);
		    out.writeInt(array[i]);
		}
		out.write(']');
	}

	private void writeComma(SerializeWriter out, int i) {
		if (i != 0) {
		    out.write(',');
		}
	}
}
