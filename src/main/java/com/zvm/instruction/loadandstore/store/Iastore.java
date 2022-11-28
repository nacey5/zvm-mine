package com.zvm.instruction.loadandstore.store;

import com.zvm.instruction.Instruction;
import com.zvm.interpreter.CallSite;
import com.zvm.interpreter.CodeUtils;
import com.zvm.interpreter.Interpreter;
import com.zvm.memory.ArrayFields;
import com.zvm.runtime.*;
import com.zvm.runtime.struct.JObject;

public class Iastore implements Instruction {
    @Override
    public void execute(RunTimeEnv runTimeEnv, JThread jThread, JavaClass javaClass, CallSite callSite, Interpreter interpreter, CodeUtils code) {
        JavaFrame javaFrame = jThread.getTopFrame();
        OperandStack operandStack = javaFrame.operandStack;
        LocalVars localVars = javaFrame.localVars;

        int value = operandStack.popInt();
        int index = operandStack.popInt();
        JObject arrayObject = operandStack.popJObject();
        ArrayFields arrayFields = runTimeEnv.javaHeap.arrayContainer.get(arrayObject.offset);
        arrayFields.putInt(index, value);
    }
}
