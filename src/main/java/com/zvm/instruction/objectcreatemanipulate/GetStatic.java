package com.zvm.instruction.objectcreatemanipulate;

import com.zvm.classfile.ClassFile;
import com.zvm.classfile.FieldInfo;
import com.zvm.classfile.constantpool.ConstantBase;
import com.zvm.instruction.Instruction;
import com.zvm.interpreter.CallSite;
import com.zvm.interpreter.CodeUtils;
import com.zvm.interpreter.Interpreter;
import com.zvm.interpreter.Ref;
import com.zvm.runtime.*;

/**
 * @author Rail
 */
public class GetStatic implements Instruction {

    @Override
    public void execute(RunTimeEnv runTimeEnv, JThread jThread, JavaClass javaClass, CallSite callSite, Interpreter interpreter, CodeUtils code) {
        JavaFrame javaFrame = jThread.getTopFrame();
        OperandStack operandStack = javaFrame.operandStack;
        LocalVars localVars = javaFrame.localVars;

        short staticIndex = code.consumeU2();
        ClassFile classFile = javaClass.getClassFile();
        ConstantBase[] constant_bases = classFile.constantPool.cpInfo;
        ConstantBase constant_base = constant_bases[staticIndex - 1];
        Ref fieldRef = JavaClass.processRef(javaClass, constant_base);

        FieldInfo field_info = JavaClass.parseFieldRef(runTimeEnv, fieldRef, interpreter);
        int slotId = field_info.slotId;
        JavaClass javaClass1 = runTimeEnv.methodArea.findClass(fieldRef.className);
        StaticVars staticVars = javaClass1.staticVars;
        char s = fieldRef.descriptorName.charAt(0);
        if(s == 'Z' || s == 'B' || s == 'C' || s == 'S' || s == 'I'){
            operandStack.putInt(staticVars.getIntByIndex(slotId));
        }else if ( s == 'J' ){
            operandStack.putLong(staticVars.getLongByIndex(slotId));
        }else if (s == 'F'){
            operandStack.putFloat(staticVars.getFloat(slotId));
        }else if (s == 'D'){
            operandStack.putDouble(staticVars.getDouble(slotId));
        }else if(s == 'L' || s== '['){
            /*bug*/
            operandStack.putJObject(staticVars.getJObject(slotId));
        }
    }
}
