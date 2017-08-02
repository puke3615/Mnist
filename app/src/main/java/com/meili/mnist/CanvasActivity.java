package com.meili.mnist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.meili.mnist.mnist.MnistClassifier;
import com.meili.mnist.mnist.MnistData;
import com.meili.mnist.widget.CanvasView;

/**
 * @author zijiao
 * @version 17/8/2
 */
public class CanvasActivity extends Activity {

    private CanvasView canvasView;
    private TextView resultPanel;
    private MnistClassifier classifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        canvasView = (CanvasView) findViewById(R.id.canvas_view);
        resultPanel = (TextView) findViewById(R.id.result_panel);
        classifier = new MnistClassifier(getAssets());
    }

    // 擦除
    public void onClean(View view) {
        canvasView.clean();
        resultPanel.setText(null);
    }

    // 识别
    public void onInference(View view) {
        if (canvasView.isEmpty()) {
            resultPanel.setText("画板为空");
            return;
        }
        MnistData result = classifier.inference(canvasView.fetchData(28, 28));
        resultPanel.setText(result.top(3));
    }
}
