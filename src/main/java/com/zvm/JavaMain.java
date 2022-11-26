package com.zvm;

import com.zvm.jnative.NativeUtils;
import com.zvm.runtime.RunTimeEnv;

/**
 * @NAME: JavaMain
 * @USER: DaHuangGO
 * @DATE: 2022/11/26
 * @TIME: 13:35
 * @YEAR: 2022
 * @MONTH: 11
 * @DAY: 26
 */
public class JavaMain {
    public static void main(String[] args){
        Cmd.processCmd(args);
        RunTimeEnv zvmEnv = new RunTimeEnv();
        //String curClassNamePath = Cmd.curClassNamePath;
        String curClassName = Cmd.curClassName;
        System.out.println("file path : " + curClassName);

        ZVM zvm = new ZVM(zvmEnv);

        NativeUtils nativeUtils = new NativeUtils();
        nativeUtils.registerNatives();



        zvm.callMain("main", "([Ljava/lang/String;)V", curClassName);
    }

}
