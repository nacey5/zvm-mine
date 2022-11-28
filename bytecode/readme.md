在进行测试的时候，可以使用-XJRE参数进行对类路径的查询，但是为了方便，
我将常用的java的字节码进行提取到bytecode包中进行参数的解析，这样
方便在进行调试的时候可以进行运行
--------------------
第一次测试结果，对于Ｓａｍｐｌｅ０的测实结果成功
参数为：
    
    -cp E:\java_project\zvm-mine\bytecode Simple0
    
第二次测试结果，对于T0ClassLink的测试结果成功
参数为:
    
    -cp E:\java_project\zvm-mine\bytecode classlink.T0ClassLink