package com.zvm.instruction;

import com.zvm.interpreter.CallSite;
import com.zvm.interpreter.CodeUtils;
import com.zvm.interpreter.Interpreter;
import com.zvm.runtime.JThread;
import com.zvm.runtime.JavaClass;
import com.zvm.runtime.RunTimeEnv;

/**
 * @NAME: Instruction
 * @USER: DaHuangGO
 * @DATE: 2022/11/28
 * @TIME: 11:13
 * @YEAR: 2022
 * @MONTH: 11
 * @DAY: 28
 */
public interface Instruction {
    /**
     * 执行指令
     */
    void execute(RunTimeEnv runTimeEnv, JThread jThread, JavaClass javaClass, CallSite callSite, Interpreter interpreter, CodeUtils code);

}
