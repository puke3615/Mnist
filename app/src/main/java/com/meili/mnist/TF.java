package com.meili.mnist;

/**
 * @author zijiao
 * @version 17/8/2
 */
public class TF {

    public static final String MODEL = "file:///android_asset/mnist.pb";

    public static final int[] INPUT_TYPE = new int[]{1, 28 * 28};
    public static final String INPUT_NAME = "input";
    public static final String KEEP_PROB_NAME = "keep_prob";
    public static final String OUTPUT_NAME = "output";

}
