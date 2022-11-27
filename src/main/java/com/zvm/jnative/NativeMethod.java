package com.zvm.jnative;

import com.zvm.runtime.JavaFrame;
import com.zvm.runtime.RunTimeEnv;

/**
 * @NAME: NativeMethod
 * @USER: DaHuangGO
 * @DATE: 2022/11/27
 * @TIME: 15:07
 * @YEAR: 2022
 * @MONTH: 11
 * @DAY: 27
 */
public interface NativeMethod {
    /**
     * 调用本地方法
     * @param javaFrame
     */
    void invoke(RunTimeEnv runTimeEnv, JavaFrame javaFrame);
}
