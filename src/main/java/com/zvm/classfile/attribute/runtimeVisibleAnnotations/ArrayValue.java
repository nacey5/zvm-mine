package com.zvm.classfile.attribute.runtimeVisibleAnnotations;

import com.zvm.basestruct.U1;
import com.zvm.basestruct.U2;

public class ArrayValue extends ElementValue {
    public U1 tag;
    public U2 numValues;
    public ElementValue[] values;
}
