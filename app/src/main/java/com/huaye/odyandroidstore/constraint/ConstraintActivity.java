package com.huaye.odyandroidstore.constraint;

import android.os.Handler;
import android.util.Log;

import com.huaye.odyandroidstore.R;
import com.huaye.odyandroidstore.base.BaseActivity;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConstraintActivity extends BaseActivity {
    Future<String> f;
    private Handler handler = new Handler();

    @Override
    protected int bindLayout() {
        return R.layout.activity_constraint;
    }

    @Override
    protected void initView() {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Log.d("samuel", "tangye");
            }
        });
        f = executor.submit(new UploadCallable("孙华辉"));

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d("samuel", f.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }, 5000);

    }

    class UploadCallable implements Callable<String> {
        private String result;

        public UploadCallable(String temp) {
            result = temp;
        }

        @Override
        public String call() throws Exception {
            Log.d("samuel", result);
            return result += ", hello world!!";
        }
    }
}
