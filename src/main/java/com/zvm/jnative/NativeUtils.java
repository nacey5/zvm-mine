package com.zvm.jnative;

import com.zvm.interpreter.Ref;
import com.zvm.runtime.JavaFrame;
import com.zvm.runtime.RunTimeEnv;

/**
 * @NAME: NativeUtils
 * @USER: DaHuangGO
 * @DATE: 2022/11/27
 * @TIME: 15:07
 * @YEAR: 2022
 * @MONTH: 11
 * @DAY: 27
 */
public class NativeUtils {

    public NativeUtils(){

    }
    /**
     * 注册本地方法
     */
    public void registerNatives() {
        /**
         *  native.Register(jlSystem, "arraycopy", "(Ljava/lang/Object;ILjava/lang/Object;II)V", arraycopy)
         */

        String method = NativeConstant.ARRAYCOPY_CLASSNAME + "~" + NativeConstant.ARRAYCOPY_DESCRIPTOR + "~" + NativeConstant.ARRAYCOPY_METHODNAME;

        registerNative(method, System::arraycopy);
    }


    public void registerNative(String method, NativeMethod nativeMethod){
        RunTimeEnv.nativeMethodMap.put(method, nativeMethod);
    }

    public static boolean hasNativeMethod(Ref ref){
        String method = new StringBuilder(ref.className).append("~").append(ref.descriptorName).append("~").append(ref.refName).toString();
        if(RunTimeEnv.nativeMethodMap.containsKey(method)){
            return true;
        }
        return false;
    }

    private static NativeMethod findNativeMethod(Ref ref){
        String method = new StringBuilder(ref.className).append("~").append(ref.descriptorName).append("~").append(ref.refName).toString();
        return RunTimeEnv.nativeMethodMap.get(method);
    }

    public static void executeMethod(RunTimeEnv runTimeEnv, JavaFrame javaFrame, Ref ref){
        NativeMethod nativeMethod = findNativeMethod(ref);
        if(nativeMethod != null){
            nativeMethod.invoke(runTimeEnv, javaFrame);
        }
    }
}
