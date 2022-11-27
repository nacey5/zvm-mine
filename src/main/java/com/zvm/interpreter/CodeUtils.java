package com.zvm.interpreter;

import com.zvm.basestruct.U1;

/**
 * @NAME: CodeUtils
 * @USER: DaHuangGO
 * @DATE: 2022/11/27
 * @TIME: 15:07
 * @YEAR: 2022
 * @MONTH: 11
 * @DAY: 27
 */
/**
 * 方法中 Code 属性的读取工具
 * @author Rail
 */
public class CodeUtils {
    public U1[] code;
    private int pc;

    public CodeUtils(U1[] code, int pc){
        this.code = code;
        this.pc = pc;
    }

    public byte consumeU1(){
        byte res = code[++pc].u1[0];
        return res;
    }

    public short consumeU2(){
        byte res0 = consumeU1();
        byte res1 = consumeU1();
        short res = (short) ((res0 << 8) | (res1 & 0xff));
        return res;
    }

    public short readU2(){
        byte res0 = code[pc + 1].u1[0];
        byte res1 = code[pc + 2].u1[0];
        short res = (short) ((res0 << 8) | (res1 & 0xff));
        return res;
    }

    public byte readU1(){
        byte res0 = code[pc + 1].u1[0];
        return res0;
    }

    public void pcAdd(int offset){
        pc += offset;
    }

    /**
     *循环默认加 1，这里先减回来
     * @param offset
     */
    public void pcAddBackOne(int offset){
        pc += offset;
        pc --; /*循环默认加 1，这里先减回来*/
    }

    public int getPc(){
        return pc;
    }

}
