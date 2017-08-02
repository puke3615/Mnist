package com.meili.mnist.mnist;

import android.content.res.AssetManager;

import com.meili.mnist.TF;

import org.tensorflow.contrib.android.TensorFlowInferenceInterface;

/**
 * @author zijiao
 * @version 17/8/2
 */
public class MnistClassifier {

    private final TensorFlowInferenceInterface inference;

    public MnistClassifier(AssetManager assetManager) {
        inference = new TensorFlowInferenceInterface();
        inference.initializeTensorFlow(assetManager, TF.MODEL);
        inference.fillNodeFloat(TF.KEEP_PROB_NAME, new int[]{1}, new float[]{1.0f});
    }

    public MnistData inference(float[] input) {
        if (input == null || input.length != 28 * 28) {
            throw new RuntimeException("Input data is error.");
        }
        inference.fillNodeFloat(TF.INPUT_NAME, TF.INPUT_TYPE, input);
        inference.runInference(new String[]{TF.OUTPUT_NAME});
        float[] output = new float[10];
        inference.readNodeFloat(TF.OUTPUT_NAME, output);
        return new MnistData(output);
    }

}
