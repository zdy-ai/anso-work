package com.example.anso11springapp.service;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * 语音播报(window)
 * @author Eric
 * @create 2022-07-16 16:45
 */
public class StaticTools {

    /**【语音播报方法】**/
    public static boolean speakingText(String readText){
        boolean isFinish = true;
        ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
        try {
            sap.setProperty("Volume",new Variant(100));              // 音量 0-100
            sap.setProperty("Rate",new Variant(-1));                 // 语音朗读速度 -10 到 +10
            Dispatch sapo = sap.getObject();                         // 获取执行对象
            Dispatch.call(sapo,"Speak",new Variant(readText));    	// 执行朗读
            sapo.safeRelease();                                     // 关闭执行对象
        }catch (Exception e){
            isFinish = false;
            e.printStackTrace();
        }finally {
            sap.safeRelease();                                      // 关闭执行对象
        }
        return isFinish;
    }

    public static void main(String[] args) {
        StaticTools.speakingText("您有一笔新的订单，请注意查收");
    }
}

