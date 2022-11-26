package com.zvm;

import com.zvm.interpreter.Interpreter;
import com.zvm.runtime.JavaClass;
import com.zvm.runtime.RunTimeEnv;

/**
 * @NAME: ZVM
 * @USER: DaHuangGO
 * @DATE: 2022/11/26
 * @TIME: 13:35
 * @YEAR: 2022
 * @MONTH: 11
 * @DAY: 26
 */
public class ZVM {
    public static RunTimeEnv zvmEnv;
    public ZVM(RunTimeEnv zvmEnv){
        ZVM.zvmEnv = zvmEnv;
    }

    public void callMain(String main, String descriptor, String classPath){
        JavaClass javaClass = zvmEnv.methodArea.loadClass(classPath);
        Interpreter interpreter = new Interpreter(zvmEnv);
        interpreter.initInstructions();
        zvmEnv.methodArea.linkClass(classPath);
        interpreter.invokeByName(javaClass, main, descriptor);
        System.out.println();
    }


}
